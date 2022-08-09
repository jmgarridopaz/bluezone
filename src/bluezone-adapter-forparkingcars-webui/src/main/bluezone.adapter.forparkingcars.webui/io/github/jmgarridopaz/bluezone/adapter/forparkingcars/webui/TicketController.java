package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.PurchaseTicketRequest;
import io.github.jmgarridopaz.bluezone.hexagon.Rate;
import io.github.jmgarridopaz.bluezone.hexagon.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Clock;
import java.util.Collection;
import java.util.Map;


@Controller
public class TicketController {

    private final ForParkingCars carParker;

    @Autowired
    public TicketController(ForParkingCars carParker ) {
        this.carParker = carParker;
    }

    @GetMapping("/ticket")
    public String showTicket (@RequestParam(value = "code") String ticketCode, Model model ) {
        Ticket ticket = this.carParker.getTicket(ticketCode);
        model.addAttribute("ticket", ticket );
        return "ticket";
    }

}
