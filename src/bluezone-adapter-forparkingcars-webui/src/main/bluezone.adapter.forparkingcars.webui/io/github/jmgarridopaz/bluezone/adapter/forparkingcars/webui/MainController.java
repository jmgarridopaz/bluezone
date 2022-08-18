package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping( {"/","/index"} )
    public String showWelcome() {
        return "index";
    }

}
