package kg.edu.iaau.beeline.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController
{
    @RequestMapping(
            value = {"/"},
            method = {RequestMethod.GET})
    public String getDashboard()
    {
        return "/dashboard";
    }
}
