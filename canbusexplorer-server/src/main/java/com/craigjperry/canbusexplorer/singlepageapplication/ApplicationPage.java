package com.craigjperry.canbusexplorer.singlepageapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationPage {

    @RequestMapping("/")
    public String index(Model model) {
        return "application_page";
    }

}
