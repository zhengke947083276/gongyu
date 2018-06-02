package org.com.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jxl.read.biff.BiffException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.com.entity.TblDorm;
import org.com.entity.TblStudent;
import org.com.service.TblStudentService;
import org.com.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class Stu {
    @Autowired
    TblStudentService tblStudentService;
    @Autowired
    ServletContext servletContext;
    @RequestMapping("/add")
    public String add(){
        return "stu/add";
    }


    @RequestMapping("/updateAll")
    public String updateAll(int stuId,Model model){
        TblStudent tblStudent = tblStudentService.selectStuAndSpeAndFacBy(stuId);
        model.addAttribute("tblStudent",tblStudent);
        return "stu/update";
    }




    /**
     * 导入jackson包
     * @return
     */
    @RequestMapping("/selectTblStudentByStuState1")
    @ResponseBody
    public List<TblStudent> selectTblStudentByStuState1(){
        List<TblStudent> tblStudents = tblStudentService.selectTblStudentByStuState1();
        return tblStudents;
    }

    @RequestMapping(value="/importStudent")
    public String importStudent(HttpServletRequest request, HttpServletResponse response, @RequestParam("file")MultipartFile file) throws IOException, BiffException, ParseException {
        ExcelUtils excelUtils = new ExcelUtils();
        List<String[]> list = excelUtils.importExcel(file);
        List<TblStudent> tblStudents = new ArrayList<TblStudent>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (String[] strings :list) {

            TblStudent tblStudent = new TblStudent();
            tblStudent.setStuId(Integer.valueOf(strings[0]));
            tblStudent.setStuNo(strings[1]);
            tblStudent.setStuPeriod(strings[2]);
            tblStudent.setStuName(strings[3]);
            tblStudent.setSpeId(Integer.valueOf(strings[4]));
            //字符串转换为时间类型
            Date format = dateFormat.parse(strings[5]);
            System.out.println(format);
            tblStudent.setStuBirthday(format);
            tblStudent.setStuSex(Boolean.valueOf(strings[6]));
            tblStudent.setStuPhone(strings[7]);
            tblStudent.setStuPicture(strings[8]);
            tblStudent.setStuAddress(strings[9]);
            tblStudent.setStuState(Integer.valueOf(strings[10]));
            System.out.println(tblStudent);
            tblStudents.add(tblStudent);
        }
        tblStudentService.addTblDormFor(tblStudents);
        return "redirect:/stu/select";
    }


    @RequestMapping("/exportStudent")
    public String exportStudent() throws Exception{
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("学生表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //添加第一行的标题
        String[] strs = {"序号(stu_id)","学号(stu_no)","级(stu_period)","姓名(stu_name)",
                "专业号(spe_id)","生日(stu_birthday)","性别(stu_sex)","电话(stu_phone)",
                "图片(stu_picture)","家庭地址(stu_address)","学生状态(stu_state)"};
        HSSFCell cell = null;
        for (int i = 0; i <strs.length ; i++) {
            cell = row.createCell(i);
            cell.setCellValue(strs[i]);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到
        List<TblStudent> tblStudents = tblStudentService.selectAll();
        for(int i=0;i<tblStudents.size();i++){
            row = sheet.createRow(i+1);
            TblStudent tblStudent = (TblStudent)tblStudents.get(i);
            row.createCell(0).setCellValue(tblStudent.getStuId());
            row.createCell(1).setCellValue(tblStudent.getStuNo());
            row.createCell(2).setCellValue(tblStudent.getStuPeriod());
            row.createCell(3).setCellValue(tblStudent.getStuName());
            row.createCell(4).setCellValue(tblStudent.getSpeId());
            Date stuBirthday = tblStudent.getStuBirthday();
            String format = simpleDateFormat.format(stuBirthday);
            row.createCell(5).setCellValue(format);
            row.createCell(6).setCellValue(tblStudent.getStuSex());
            row.createCell(7).setCellValue(tblStudent.getStuPhone());
            row.createCell(8).setCellValue(tblStudent.getStuPicture());
            row.createCell(9).setCellValue(tblStudent.getStuAddress());
            row.createCell(10).setCellValue(tblStudent.getStuState());
        }
        // 第六步，将文件存到指定位置
        String realPath = servletContext.getRealPath("/");

        FileOutputStream fileOutputStream = new FileOutputStream("D:/dasan/g/公寓Excel/"+"exportStudent.xls");
        wb.write(fileOutputStream);
        fileOutputStream.close();
        return "redirect:/stu/select";
    }


    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(TblStudent tblStudent){
        System.out.println(tblStudent);
        int i = tblStudentService.addTblStudent(tblStudent);
        System.out.println(i);
        return "redirect:/stu/select";
    }

    @RequestMapping(value = "/selectByStuState2AndSpeId")
    @ResponseBody
    public List<TblStudent> selectByStuState2AndSpeId(Integer speId){
        return tblStudentService.selectTblStudentByStuState2AndSpeId(speId);
    }

    @RequestMapping(value = "/select")
    public String select(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
        //        //引入pagehelper插件
        //查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后就是一个分页查询
        List<TblStudent> tblStudents = tblStudentService.selectStuAndSpeAndFacAll();
        //使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询出来的数据,c传入连续显示的页数
        PageInfo pageInfo = new PageInfo(tblStudents,5);
        model.addAttribute("pageInfo",pageInfo);
        return "stu/select";
    }
    @RequestMapping("/delete")
    public String delete(Integer stuId){
        int i = tblStudentService.deleteStudent(stuId);
        System.out.println(i);
        return "redirect:/stu/select";
    }


    @RequestMapping("/update")
    public String update(TblStudent tblStudent,Integer state){
       //修改
        System.out.println("====================="+tblStudent.getStuId()+"   "+tblStudent.getStuState()+"   "+state);
        int i = tblStudentService.updateTblStudent(tblStudent.getStuId(),state ,tblStudent.getStuState() );
        System.out.println(i);
        return "redirect:/stu/select";
    }

    @RequestMapping(value = "/updateUpload",method = RequestMethod.POST)
    public String updateUpload(TblStudent tblStudent, @RequestParam("file") MultipartFile file) throws IOException {
        String realPath = servletContext.getRealPath("/");
//        String path = "D:/dasan/g/src/main/webapp/";


        System.out.println(realPath);// D:\dasan\g\target\ParkingSystem\
        System.out.println(file.getOriginalFilename());
        String filename = file.getOriginalFilename();//文件名
        tblStudent.setStuPicture(tblStudent.getStuName()+filename);
        int i = tblStudentService.updateTblStudent(tblStudent);
        System.out.println(tblStudent+"*******************************");
        if (!file.isEmpty()){//文件是否存在
            File file1 = new File(realPath+"student/picture",tblStudent.getStuName()+file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(),file1);
        }
        return "redirect:/stu/select";
    }

    @RequestMapping(value = "/addUpload",method = RequestMethod.POST)
    public String addUpload(TblStudent tblStudent, @RequestParam("file") MultipartFile file) throws IOException {

        String realPath = servletContext.getRealPath("/");
//        String path = "D:/dasan/g/src/main/webapp/";
//        System.out.println(contextPath);// D:\dasan\g\target\ParkingSystem\
//        System.out.println(file.getOriginalFilename());
        String filename = file.getOriginalFilename();//文件名
        tblStudent.setStuPicture(tblStudent.getStuName()+filename);
        int i = tblStudentService.addTblStudent(tblStudent);
        if (!file.isEmpty()){//文件是否存在
            File file1 = new File(realPath+"student/picture",tblStudent.getStuName()+file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(),file1);
        }
        return "redirect:/stu/select";
    }






    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        if (!file.isEmpty()){//文件是否存在
            File file1 = new File("D:/dasan/g/src/main/webapp/student/picture",file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(),file1);
        }
        return "stu/add";
    }
}
