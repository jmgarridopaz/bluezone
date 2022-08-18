package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.Rate;
import io.github.jmgarridopaz.bluezone.hexagon.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GetTicketController {

    private final ForParkingCars carParker;

    @Autowired
    public GetTicketController(ForParkingCars carParker ) {
        this.carParker = carParker;
    }

    @PostMapping("/getTicket")
    public String submitForm ( Model model, @RequestParam("ticketCode") String ticketCode ) {
        Ticket ticket = this.carParker.getTicket(ticketCode);
        model.addAttribute("ticket", ticket );
        Rate ticketRate = this.carParker.getAllRatesByName().get(ticket.getRateName());
        model.addAttribute( "ticketRate", ticketRate );
        return "getTicketOut";
    }

}
