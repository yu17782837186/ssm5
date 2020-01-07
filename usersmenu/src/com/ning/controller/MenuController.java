package com.ning.controller;

import com.ning.pojo.Menu;
import com.ning.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {
    @RequestMapping("getMenu")
    @ResponseBody
    public List<Menu> showMenu(HttpSession session){
        return ((Users)session.getAttribute("user")).getMenus();
    }
}
