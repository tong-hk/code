package com.thk.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thk.entity.Admin;
import com.thk.service.AdminService;
@Controller
public class AdminController {

    @Autowired
    AdminService adminService=null;

    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request){
    	//System.out.println(admin.getAcname());
        request.getSession ().setAttribute ("PATH_WAY",request.getContextPath ());
        Admin admin1=adminService.checkUsernameAndPwd (admin);
        //System.out.println(admin1.getLp());
        if(admin1.getAcname ()==null){
            return "login";
        }
        request.getSession().setAttribute("admin1", admin1);
        return "index";
    }

    @RequestMapping("/changePaw")
    public void password(HttpServletRequest request,PrintWriter out){
        String oldpsw=request.getParameter ("old_password");
        String newpsw=request.getParameter ("new_password");
        String newpsw1=request.getParameter ("new_password1");
        Admin admin=(Admin)request.getSession ().getAttribute ("admin");

        try {
            if ("".equals (oldpsw) || oldpsw == null) {
                out.print ("sadas");
            } else if (!newpsw.equals (newpsw1)) {
                out.print ("两次密码输入不相同");
            } else if (oldpsw.equals (admin.getApwd ())) {
                admin.setApwd (newpsw);
                boolean a = adminService.updateApwd (admin);
                if (a) {
                    out.print ("修改成功");
                } else {
                    out.print ("修改失败");
                }
            }
        }finally {
            out.close ();
        }
    }
    @RequestMapping("/userMessage")
    public void userMessage(Admin admin,HttpSession session,PrintWriter pw){
        Admin admin1= (Admin) session.getAttribute ("admin");
        admin.setId (admin1.getId ());
        boolean success=adminService.updatePrsonalInformation (admin);
        try {
            if (success) {
                pw.print ("修改成功");
            }else {
                pw.print ("修改失败");
            }
        }finally {
            pw.close ();
        }
    }

}

