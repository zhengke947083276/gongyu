package org.com.view;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import org.com.entity.TblDorm;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ViewExcel extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String fileName = "宿舍列表excel.xls";
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/ms-excel");
        httpServletResponse.setHeader("Content-Disposition", "inline; filename="+new String(fileName.getBytes(),"iso8859-1"));
        OutputStream outputStream = httpServletResponse.getOutputStream();
        List<TblDorm> tblDormList = (List<TblDorm>) map.get("tblDormList");
        // 产生Excel表头
        Sheet sheet = workbook.createSheet("宿舍表1");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        Row row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //添加第一行的标题
        Cell cell = row.createCell(0);
        cell.setCellValue("id");
        cell=row.createCell(1);
        cell.setCellValue("name");
        cell=row.createCell(2);
        cell.setCellValue("state");
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到
//        for(int i=0;i<tblDormList.size();i++){
//            row = sheet.createRow(i+1);
//            TblDorm tblDorm = (TblDorm)tblDormList.get(i);
//            row.createCell(0).setCellValue(tblDorm.getDormId());
//            row.createCell(1).setCellValue(tblDorm.getDormName());
//            row.createCell(2).setCellValue(tblDorm.getDormState());
//        }
//        workbook.write(outputStream);
//        outputStream.flush();
//        outputStream.close();
    }
}
