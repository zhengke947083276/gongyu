package org.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.*;
import org.com.entity.TblCheck;
import org.com.entity.TblStudent;
import org.com.entity.TblVisit;
import org.com.service.TblCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/che")
public class Che {
    @Autowired
    TblCheckService tblCheckService;

    @RequestMapping("/add")
    public String add(){
        return "che/add";
    }
    @RequestMapping("insert")
    public String insert(TblCheck tblCheck){
        int i = tblCheckService.addTblCheck(tblCheck);
        System.out.println(i);
        return "redirect:/che/selectAll";
    }
    @RequestMapping("/delete")
    public String delete(TblCheck tblCheck){
        tblCheckService.delete(tblCheck.getCheckId());
        return "redirect:/che/selectAll";
    }
    @RequestMapping("/update")
    public String update(int checkId,int stuState){
        System.out.println(checkId+"  "+stuState);
        tblCheckService.updateTblCheck(checkId, stuState);
        return "redirect:/che/selectAll";
    }

    @RequestMapping("/selectAll")
    public String selectAll(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
        //        //引入pagehelper插件
        //查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后就是一个分页查询
        List<TblCheck> tblChecks = tblCheckService.selectCheAndStuAndDormAll();
        PageInfo pageInfo = new PageInfo(tblChecks,5);
        model.addAttribute("pageInfo",pageInfo);
        return "che/select";
    }

    @RequestMapping("/selectWithDormByCheckState1AndStuId")
    @ResponseBody
    public TblCheck selectWithDormByCheckState1AndStuId(Integer stuId){
        return tblCheckService.selectWithDormByCheckState1AndStuId(stuId);
    }


    @RequestMapping("/exportTblCheck")
    public String exportTblCheck() throws Exception{
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("入住表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //添加第一行的标题
        HSSFCell cell = null;
        String[] strs = {"序号(check_id)","宿舍id(dorm_id)","学生id(stu_id)",
                "入住时间(check_in_time)","毕业时间(check_out_time)","入住状态(check_state)"};
        for (int i = 0; i <strs.length ; i++) {
            cell = row.createCell(i);
            cell.setCellValue(strs[i]);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到
        List<TblCheck> tblChecks = tblCheckService.selectAll();
        for(int i=0;i<tblChecks.size();i++){
            row = sheet.createRow(i+1);
            TblCheck tblCheck = tblChecks.get(i);
            row.createCell(0).setCellValue(tblCheck.getCheckId());
            row.createCell(1).setCellValue(tblCheck.getDormId());
            row.createCell(2).setCellValue(tblCheck.getStuId());
            Date checkInTime = tblCheck.getCheckInTime();
            String format1 = simpleDateFormat.format(checkInTime);
            row.createCell(3).setCellValue(format1);
            Date checkOutTime = tblCheck.getCheckOutTime();
            if (checkOutTime!=null) {
                String format2 = simpleDateFormat.format(checkOutTime);
                row.createCell(4).setCellValue(format2);
            }
            row.createCell(5).setCellValue(tblCheck.getCheckState());
        }
        // 第六步，将文件存到指定位置
//        String realPath = servletContext.getRealPath("/");

        FileOutputStream fileOutputStream = new FileOutputStream("D:/dasan/g/公寓Excel/"+"exportTblCheck.xls");
        wb.write(fileOutputStream);
        fileOutputStream.close();
        return "redirect:/che/selectAll";

    }
}
