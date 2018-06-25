package org.com.controller;

import org.com.entity.TblAdministrator;
import org.com.service.TblAdministratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class Adm {
    @Autowired
    TblAdministratorService tblAdministratorService;
    @Autowired
    ServletContext servletContext;
//        return "redirect:/*/*";// 请求重定向
//        return "forward:/*/*";//forward转发
    @RequestMapping(value = "/adm/login")
    public String login(HttpServletRequest request,HttpSession session,HttpServletResponse response,Integer day) {
        System.out.println(day);
        String admUser = request.getParameter("admUser");
        String admPass = request.getParameter("admPass");
        if (day!=null && !day.equals("")){//用户勾选了7天自动登录
            //创建登录名的cookie
            Cookie admUserCookie = new Cookie("admUser",admUser);
            //创建密码的cookie
            Cookie admPassCookie = new Cookie("admPass",admPass);
            //设置两个Cookie的最大存活期
            admUserCookie.setMaxAge(day*24*60*60);
            admPassCookie.setMaxAge(day*24*60*60);
            //设置两个cookie的path
            admUserCookie.setPath("/");
            admPassCookie.setPath("/");
            //将两个Cookie添加到response对象中
            response.addCookie(admUserCookie);
            response.addCookie(admPassCookie);
        }
        System.out.println(admUser+" "+admPass);
        TblAdministrator tblAdministrator = tblAdministratorService.administratorLogin(admUser,admPass);
        System.out.println("================="+tblAdministrator);
        if (tblAdministrator!=null){
            session.setAttribute("user",tblAdministrator);
        }
        return "index";// /WEB-INF/**.jsp
    }
    @RequestMapping("/adm/exit")
    public String exit(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length!=0){
            for(Cookie cookie :cookies){
                //检测登录名是否存在cookie中
                if(cookie.getName().equals("admUser")){
                    cookie.setMaxAge(0);//设置为0直接从cookie中移除，设置为-1缓存在浏览器中
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }else if(cookie.getName().equals("admPass")){//检测登录密码是否存在cookie中
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
        session.removeAttribute("user");
        session.invalidate();
        return "index";
    }
    @RequestMapping("/adm/update")
    public String update(TblAdministrator tblAdministrator,HttpServletRequest request,HttpServletResponse response,HttpSession session){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length!=0){
            for(Cookie cookie :cookies){
                //检测登录名是否存在cookie中
                if(cookie.getName().equals("admUser")){
                    cookie.setMaxAge(0);//设置为0直接从cookie中移除，设置为-1缓存在浏览器中
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }else if(cookie.getName().equals("admPass")){//检测登录密码是否存在cookie中
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
        tblAdministratorService.administratorSet(tblAdministrator);
        session.removeAttribute("user");
        session.invalidate();
        return "index";
    }



    @RequestMapping("/")
    public String autoLogin(HttpServletRequest request) throws Exception {
        //设置项目根路径
        String contextPath = servletContext.getContextPath();
        servletContext.setAttribute("contextPath",contextPath);
        //获取cookie中存放的数据
        Cookie[] cookies = request.getCookies();
        String admUser=null;
        String admPass=null;
        if (cookies!=null && cookies.length!=0){
            //2.检测是否存在用户登录的数据
            for (Cookie cookie:cookies){
                //检测登录名是否存在cookie中
                if (cookie.getName().equals("admUser")){
                    admUser = cookie.getValue();//获得登录名
                }else if (cookie.getName().equals("admPass")){
                    admPass = cookie.getValue();
                }
            }
            System.out.println(admUser +"   "+admPass);
            //判断登录名和密码是否存在
            if (admUser!=null && admPass!=null && !admUser.equals("") && !admPass.equals("")){
                //跳转到loginServlet进行登录，同时将登录名和密码传入
                return "forward:/adm/login?admUser="+admUser+"&admPass="+admPass;
            }else{//跳到登录页面
                return "index";
            }
        }else {
            return "index";
        }
    }
}
