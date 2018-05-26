package org.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.com.entity.TblDorm;
import org.com.entity.User;
import org.com.service.TblDormService;
import org.com.util.ExcelUtils;
import org.com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dorm")
public class Dorm {
    @Autowired
    TblDormService tblDormService;

    @RequestMapping("/add")
    public String jinChu(){
        return "dorm/add";
    }

    @RequestMapping(value="/importDorm")
    public String importDorm(HttpServletRequest request, HttpServletResponse response, @RequestParam("file")MultipartFile file) throws IOException, BiffException {
        ExcelUtils excelUtils = new ExcelUtils();
        List<String[]> list = excelUtils.importExcel(file);

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
//        inputStream.close();
        List<TblDorm> tblDorms = new ArrayList<TblDorm>();
        for (String[] strings :list) {
            TblDorm tblDorm = new TblDorm();
            tblDorm.setDormId(Integer.valueOf(strings[0]));
            tblDorm.setDormName(strings[1]);
            tblDorm.setDormState(Integer.valueOf(strings[2]));
            tblDorms.add(tblDorm);
        }
        int i = tblDormService.addTblDormFor(tblDorms);
        System.out.println(i);
        return "redirect:/dorm/selectPage";
    }


    @RequestMapping("/insert")
    public String insert(String d, String c, Integer h, TblDorm tblDorm){
        String str;
        if (h/10==0){
            str=d+"#"+c+"0"+h;
        }else{
            str=d+"#"+c+h;
        }
        System.out.println(str);
        tblDorm.setDormName(str);
        int i = tblDormService.addTblDorm(tblDorm);
        System.out.println(i);
        return "redirect:/dorm/selectPage";
    }

    @RequestMapping("/insertFor")
    public String insertFor(Integer d1,Integer d2, Integer c1,Integer c2, Integer h1,Integer h2){
        List<TblDorm> tblDorms = new ArrayList<TblDorm>();
        String str="";
        for (int i = d1; i <=d2; i++) {
            for (int j = c1; j <=c2; j++) {
                for (int k = h1; k <=h2; k++) {
                    TblDorm tblDorm = new TblDorm();
                    if (k/10==0){
                        str=i+"#"+j+"0"+k;
                    }else {
                        str=i+"#"+j+k;
                    }
                    tblDorm.setDormName(str);
                    tblDorms.add(tblDorm);
                }
            }
        }
        tblDormService.addTblDormFor(tblDorms);
        return "redirect:/dorm/selectPage";
    }

    /**
     * 导入jackson包
     * @return
     */
    @RequestMapping("/selectByDormState1")
    @ResponseBody
    public List<TblDorm> selectTblDormByDormState1(){
        List<TblDorm> tblDorms = tblDormService.selectTblDormByDormState1();
        return tblDorms;
    }
//
//    @RequestMapping("/selectAll")
//    public String selectAll(Model model){
//        List<TblDorm> tblDorms = tblDormService.selectAll();
//        model.addAttribute("dorms",tblDorms);
//        return "dorm/select";
//    }
    @RequestMapping("/selectPage")
    public String selectPage(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
        //引入pagehelper插件
        //查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,10);
        //startPage后就是一个分页查询
        List<TblDorm> tblDorms = tblDormService.selectAll();
        //使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询出来的数据,c传入连续显示的页数
        PageInfo page = new PageInfo(tblDorms,5);
        model.addAttribute("pageInfo",page);
        return "dorm/select";
    }

    @RequestMapping("/delete")
    public String delete(Integer dormId){
        int i = tblDormService.deleteById(dormId);
        System.out.println(i);
        return "redirect:/dorm/selectPage";
    }
    @RequestMapping("/update")
    public String update(TblDorm tblDorm){
        int i = tblDormService.updateByDormState(tblDorm.getDormId(), tblDorm.getDormState());
        System.out.println(i);
        return "redirect:/dorm/selectPage";
    }
}
