package org.com.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jxl.read.biff.BiffException;
import org.apache.commons.io.FileUtils;
import org.com.entity.TblStudent;
import org.com.service.TblStudentService;
import org.com.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
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

    @RequestMapping(value = "/addUpload",method = RequestMethod.POST)
    public String addUpload(TblStudent tblStudent, @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        String contextPath = session.getServletContext().getRealPath("/");
//        System.out.println(contextPath);// D:\dasan\g\target\ParkingSystem\
//        System.out.println(file.getOriginalFilename());
        String filename = file.getOriginalFilename();//文件名
        tblStudent.setStuPicture(filename);
        int i = tblStudentService.addTblStudent(tblStudent);
        if (!file.isEmpty()){//文件是否存在
            File file1 = new File(contextPath+"student/picture",tblStudent.getStuName()+file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(),file1);
        }
        return "redirect:/stu/select";
    }


    @RequestMapping(value = "/updateUpload",method = RequestMethod.POST)
    public String updateUpload(TblStudent tblStudent, @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        String contextPath = session.getServletContext().getRealPath("/");
//        System.out.println(contextPath);// D:\dasan\g\target\ParkingSystem\
//        System.out.println(file.getOriginalFilename());
        String filename = file.getOriginalFilename();//文件名
        tblStudent.setStuPicture(filename);
        int i = tblStudentService.updateTblStudent(tblStudent);
        if (!file.isEmpty()){//文件是否存在
            File file1 = new File(contextPath+"student/picture",tblStudent.getStuName()+file.getOriginalFilename());
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
