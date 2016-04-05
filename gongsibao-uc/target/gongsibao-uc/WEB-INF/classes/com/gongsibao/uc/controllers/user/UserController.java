package com.gongsibao.uc.controllers.user;


import com.gongsibao.common.util.StringUtils;
import com.gongsibao.common.util.page.Pager;
import com.gongsibao.common.util.page.ResponseData;
import com.gongsibao.user.entity.InnerUser;
import com.gongsibao.user.service.InnerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private InnerUserService innerUserService;

    @RequestMapping(value = "/add")
    public ResponseData add(HttpServletRequest request, HttpServletResponse response, @ModelAttribute InnerUser innerUser) {
        ResponseData data = new ResponseData();
        System.out.println(innerUser.getAddTime());
        System.out.println(request.getParameter("addTime"));
        //InnerUser innerUser = new InnerUser();
//        innerUser.setName(request.getParameter("name"));
//        innerUser.setMobile(request.getParameter("mobile"));
//        innerUser.setRealName(request.getParameter("realName"));
//        innerUser.setPasswd(request.getParameter("passwd"));
//        innerUser.setMail(request.getParameter("mail"));
        innerUserService.insert(innerUser);
        data.setMsg("操作成功");
        return data;
    }

    @RequestMapping("/delete")
    public ResponseData delete(HttpServletRequest request, HttpServletResponse response) {
        ResponseData data = new ResponseData();
        Long id = Long.valueOf(request.getParameter("id"));
        innerUserService.delete(id);
        data.setMsg("操作成功");
        return data;
    }

    @RequestMapping({"/list"})
    public ResponseData list(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String name, @RequestParam(required = false) String mobile) {
        ResponseData data = new ResponseData();
        String page = request.getParameter("page");
        if (StringUtils.isBlank(page)) {
            page = "0";
        }
        Pager<InnerUser> pager = innerUserService.pageByNameAndMobile(name, mobile, Integer.valueOf(page));
        data.setData(pager);
        return data;
    }

    @RequestMapping("/get")
    public ResponseData get(HttpServletRequest request, HttpServletResponse response, InnerUser user) {
        ResponseData data = new ResponseData();
        Long id = Long.valueOf(request.getParameter("id"));
        InnerUser innerUser = innerUserService.findById(id);
        user.getAddTime();
        data.setData(innerUser);
        return data;
    }

    @RequestMapping("/jsonView")
    public ModelAndView jsonView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("jsonView");
        Long id = Long.valueOf(request.getParameter("id"));
        mv.addObject("user", innerUserService.findById(id));
        return mv;
    }
}
