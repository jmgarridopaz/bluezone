package io.github.jmgarridopaz.bluezone.hexagon;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Permit {

    private Long			id;
    private String			carPlate;
    private String			rateName;
    private LocalDateTime	createdAt;
    private LocalDateTime	endingDateTime;
    private String			paymentTransactionId;

}
