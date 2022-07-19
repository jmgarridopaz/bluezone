package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;
import java.util.Map;


@Controller
public class BlueZoneController {

    private final ForParkingCars carParker;

    @Autowired
    public BlueZoneController ( ForParkingCars carParker ) {
        this.carParker = carParker;
    }

    @GetMapping("/index")
    public String goToHomePage() {
        return "index";
    }

    @GetMapping("/rates")
    public String showRates ( Model model ) {
        Map<String, Rate> ratesByName = this.carParker.getAllRatesByName();
        Collection<Rate> rates = ratesByName.values();
        model.addAttribute("rates", rates);
        return "rates";
    }

}