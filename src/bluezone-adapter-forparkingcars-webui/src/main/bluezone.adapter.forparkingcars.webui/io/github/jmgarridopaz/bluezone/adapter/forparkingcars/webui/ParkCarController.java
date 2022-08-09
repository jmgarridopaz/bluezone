package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.PurchaseTicketRequest;
import io.github.jmgarridopaz.bluezone.hexagon.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Clock;
import java.util.Collection;
import java.util.Map;


@Controller
public class ParkCarController {

    private final ForParkingCars carParker;

    @Autowired
    public ParkCarController(ForParkingCars carParker ) {
        this.carParker = carParker;
    }

    @GetMapping("/parkcar")
    public String showForm ( Model model ) {
        Map<String, Rate> ratesByName = this.carParker.getAllRatesByName();
        Collection<Rate> rates = ratesByName.values();
        model.addAttribute("rates", rates);
        model.addAttribute("purchaseTicketRequest", new PurchaseTicketRequest() );
        return "parkcar";
    }

    @PostMapping("/parkcar")
    public String submitForm ( @ModelAttribute PurchaseTicketRequest purchaseTicketRequest ) {
        purchaseTicketRequest.setClock ( Clock.systemDefaultZone() );
        String ticketCode = this.carParker.purchaseTicket(purchaseTicketRequest);
        return "redirect:/ticket?code="+ticketCode;
    }

}
