package com.gongsibao.order.controllers.order;

import com.gongsibao.user.entity.InnerUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by luqingrun on 16/3/28.
 */
@RestController
@RequestMapping("/user")
public class OrderController {


    @RequestMapping("/json")
    public ModelAndView getJsonUser(HttpServletRequest request, HttpServletResponse response, InnerUser u){
        InnerUser user = new InnerUser();
        user.setId(1L);

        ModelAndView mv = new ModelAndView("jsonView");
        mv.addObject("user",user);
        return mv;
    }
}
