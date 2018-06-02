package org.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.*;
import org.com.entity.TblRegistration;
import org.com.entity.TblVisit;
import org.com.service.TblVisitService;
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
@RequestMapping("/vis")
public class Vis {
    @Autowired
    TblVisitService tblVisitService;

    @RequestMapping("/add")
    public String add(){
        return "vis/add";
    }
    @RequestMapping("/insert")
    public String insert(TblVisit tblVisit){
        int i = tblVisitService.addTblVisit(tblVisit);
        System.out.println(i);
        return "redirect:/vis/select";

    }

    @RequestMapping("/delete")
    public String delete(int visId){
        int delete = tblVisitService.delete(visId);
        System.out.println(delete);
        return "redirect:/vis/select";
    }
    @RequestMapping("/select")
    public String select(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<TblVisit> tblVisits = tblVisitService.selectAll();
        PageInfo pageInfo = new PageInfo(tblVisits,5);
        model.addAttribute("pageInfo",pageInfo);
        return "vis/select";
    }

    @RequestMapping("/exportTblVisit")
    public String exportTblVisit() throws Exception{
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("来访记录表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //添加第一行的标题
        HSSFCell cell = null;
        String[] strs = {"序号(vis_id)","来访名字(vis_name)","身份证(vis_card)",
                "来访时间(vis_time)","学生id(stu_id)","描述(vis_description)"};
        for (int i = 0; i <strs.length ; i++) {
            cell = row.createCell(i);
            cell.setCellValue(strs[i]);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到
        List<TblVisit> tblVisits = tblVisitService.selectAll();
        for(int i=0;i<tblVisits.size();i++){
            row = sheet.createRow(i+1);
            TblVisit tblVisit = tblVisits.get(i);
            row.createCell(0).setCellValue(tblVisit.getVisId());
            row.createCell(1).setCellValue(tblVisit.getVisName());
            row.createCell(2).setCellValue(tblVisit.getVisCard());
            Date visTime = tblVisit.getVisTime();
            String format = simpleDateFormat.format(visTime);
            row.createCell(3).setCellValue(format);
            row.createCell(4).setCellValue(tblVisit.getStuId());
            row.createCell(5).setCellValue(tblVisit.getVisDescription());
        }
        // 第六步，将文件存到指定位置
//        String realPath = servletContext.getRealPath("/");

        FileOutputStream fileOutputStream = new FileOutputStream("D:/dasan/g/公寓Excel/"+"exportTblVisit.xls");
        wb.write(fileOutputStream);
        fileOutputStream.close();
        return "redirect:/vis/select";
    }

}