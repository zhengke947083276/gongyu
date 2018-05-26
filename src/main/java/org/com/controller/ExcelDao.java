package org.com.controller;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/excelDao")
public class ExcelDao {

    @RequestMapping("/addfor")
    public String addfor(){
        return "wenjian/addfor";
    }
//    @RequestMapping(value="/importUser")
//    public String importUser(HttpServletRequest request, HttpServletResponse response, @RequestParam("file")MultipartFile file) throws IOException, BiffException {
//        String originalFilename = file.getOriginalFilename();
//        String name = file.getName();
//        System.out.println(originalFilename+"   "+name);
//        //转换成输入流
//        InputStream inputStream = file.getInputStream();
//        //得到excel
//        Workbook workbook = Workbook.getWorkbook(inputStream);
//        //得到sheet
//        Sheet sheet = workbook.getSheet(0);
//        //获取列
//        int columns = sheet.getColumns();
//        //获取行
//        int rows = sheet.getRows();
//        System.out.println("columns="+columns+"    "+"rows="+rows);
//        //单元格
//        Cell cell = null;
//        List<String[]> list = new ArrayList<String[]>();
//        //我的excel第一行是标题,所以 i从1开始
//        for (int i = 1; i < rows; i++) {//行
//            String[] strings = new String[columns];
//            for (int j = 0;j<columns;j++){//列
//                cell = sheet.getCell(j, i);//注意:第一个参数是列.第二个参数是行
////                System.out.print(cell.getContents()+"   ");
//                strings[j]=cell.getContents();
////                map.put(j,cell.getContents());
//            }
//            list.add(strings);
//            System.out.println();
//        }
//        List<User> users = new ArrayList<User>();
//        for (String[] strings :list) {
//            User user = new User();
//            user.setdId(Integer.parseInt(strings[0]));
//            user.setdName(strings[1]);
//            user.setdPass(strings[2]);
//            user.setdAge(Integer.parseInt(strings[3]));
//            user.setdSex(strings[4]);
//            users.add(user);
//        }
//
//
//        inputStream.close();
//        return null;
//    }
}
