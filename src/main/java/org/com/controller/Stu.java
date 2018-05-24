package org.com.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.com.entity.TblStudent;
import org.com.service.TblStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
