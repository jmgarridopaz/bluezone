package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forparkingcars.PurchaseTicketRequest;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forobtainingrates.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Clock;
import java.util.Collection;
import java.util.Map;


@Controller
public class PurchaseTicketController {

    private final ForParkingCars carParker;

    @Autowired
    public PurchaseTicketController(ForParkingCars carParker ) {
        this.carParker = carParker;
    }

    @GetMapping("/purchaseTicket")
    public String showForm ( Model model ) {
        Map<String, Rate> ratesByName = this.carParker.getAllRatesByName();
        Collection<Rate> rates = ratesByName.values();
        model.addAttribute("rates", rates);
        model.addAttribute("purchaseTicketRequest", new PurchaseTicketRequest() );
        return "purchaseTicketIn";
    }

    @PostMapping("/purchaseTicket")
    public String submitForm ( Model model, @ModelAttribute("purchaseTicketRequest") PurchaseTicketRequest purchaseTicketRequest ) {
        purchaseTicketRequest.setClock ( Clock.systemDefaultZone() );
        String ticketCode = this.carParker.purchaseTicket(purchaseTicketRequest);
        model.addAttribute("ticketCode", ticketCode);
        return "purchaseTicketOut";
    }

}
