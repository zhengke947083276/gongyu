package org.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.*;
import org.com.dao.TblStudentMapper;
import org.com.entity.TblDorm;
import org.com.entity.TblRegistration;
import org.com.entity.TblStudent;
import org.com.service.TblRegistrationService;
import org.com.service.TblStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/reg")
public class Reg {
    @Autowired
    TblRegistrationService tblRegistrationService;
    @Autowired
    TblStudentService tblStudentService;

    @RequestMapping("/jinChu")
    public String jinChu(){
        return "reg/jinChu";
    }
    @RequestMapping("/add")
    public String add(TblRegistration tblRegistration, TblStudent tblStudent){
        int stuId = tblRegistrationService.addTblReg(tblRegistration, tblStudent);
        System.out.println(stuId);
//        return "forward:/reg/selectSutId?stuId="+stuId;
        return "reg/jinChu";
    }
    @RequestMapping("/select")
    public String select(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //引入pagehelper插件
        //查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后就是一个分页查询
        List<TblRegistration> tblRegistrations = tblRegistrationService.selectAll();
        //使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询出来的数据,c传入连续显示的页数
        PageInfo pageInfo = new PageInfo(tblRegistrations,5);
        model.addAttribute("pageInfo",pageInfo);
        return "reg/select";
    }
    @RequestMapping("/selectSutId")
    public String selectSutId(Model model,Integer stuId,@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        //引入pagehelper插件
        //查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,10);
        //startPage后就是一个分页查询
        List<TblRegistration> tblRegistrations = tblRegistrationService.selectAllByStuId(stuId);
        //使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询出来的数据,c传入连续显示的页数
        PageInfo pageInfo = new PageInfo(tblRegistrations,5);
        model.addAttribute("pageInfo",pageInfo);
        return "reg/select";
    }


    @RequestMapping("/delete")
    public String delete(Integer regID){
        int n = tblRegistrationService.delete(regID);
        System.out.println(n);
        return "redirect:/reg/select";
    }

    @RequestMapping("/exportTblRegistration")
    public String exportTblRegistration() throws Exception{
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("出入记录表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //添加第一行的标题
        HSSFCell cell = null;

        String[] strs = {"序号(reg_id)","学生id(stu_id)","出入时间(reg_time)","状态(reg_state)"};
        for (int i = 0; i <strs.length ; i++) {
            cell = row.createCell(i);
            cell.setCellValue(strs[i]);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到
        List<TblRegistration> tblRegistrations = tblRegistrationService.selectAll();
        for(int i=0;i<tblRegistrations.size();i++){
            row = sheet.createRow(i+1);
            TblRegistration tblRegistration = tblRegistrations.get(i);
            row.createCell(0).setCellValue(tblRegistration.getRegId());
            row.createCell(1).setCellValue(tblRegistration.getStuId());
            Date regTime = tblRegistration.getRegTime();
            String format = simpleDateFormat.format(regTime);
            row.createCell(2).setCellValue(format);
            row.createCell(3).setCellValue(tblRegistration.getRegState());
        }
        // 第六步，将文件存到指定位置
//        String realPath = servletContext.getRealPath("/");

        FileOutputStream fileOutputStream = new FileOutputStream("D:/dasan/g/公寓Excel/"+"exportTblRegistration.xls");
        wb.write(fileOutputStream);
        fileOutputStream.close();
        return "redirect:/reg/select";
    }

}
