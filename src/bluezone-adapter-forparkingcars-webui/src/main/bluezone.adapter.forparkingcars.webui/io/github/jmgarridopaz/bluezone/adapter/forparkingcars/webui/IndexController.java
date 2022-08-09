package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @Value("layout.title")
    private String layoutTitle;

    @Value("layout.footer")
    private String layoutFooter;

    @GetMapping("/index")
    public String goToHomePage(Model model) {
        model.addAttribute("layoutTitle",layoutTitle);
        model.addAttribute("layoutFooter",layoutFooter);
        return "index";
    }

}
