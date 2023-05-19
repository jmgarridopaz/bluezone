package io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying;

import lombok.*;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PayRequest {

    private String      ticketCode;
    private String      paymentCard;
    private BigDecimal  amount;

}
