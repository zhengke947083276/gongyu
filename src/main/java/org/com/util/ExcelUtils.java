package org.com.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel
 */
public  class  ExcelUtils {
    public List<String[]> importExcel(MultipartFile file) throws IOException, BiffException {
//        String originalFilename = file.getOriginalFilename();
//        String name = file.getName();
//        System.out.println(originalFilename+"   "+name);
        //转换成输入流
        InputStream inputStream = file.getInputStream();
        //得到excel
        Workbook workbook = Workbook.getWorkbook(inputStream);
        //得到sheet
        Sheet sheet = workbook.getSheet(0);
        //获取列
        int columns = sheet.getColumns();
        //获取行
        int rows = sheet.getRows();
        System.out.println("columns="+columns+"    "+"rows="+rows);
        //单元格
        Cell cell = null;
        List<String[]> list = new ArrayList<String[]>();
        //我的excel第一行是标题,所以 i从1开始
        for (int i = 1; i < rows; i++) {//行
            String[] strings = new String[columns];
            for (int j = 0;j<columns;j++){//列
                cell = sheet.getCell(j, i);//注意:第一个参数是列.第二个参数是行
                strings[j]=cell.getContents();
            }
            list.add(strings);
        }
        inputStream.close();
        return list;
    }
}
