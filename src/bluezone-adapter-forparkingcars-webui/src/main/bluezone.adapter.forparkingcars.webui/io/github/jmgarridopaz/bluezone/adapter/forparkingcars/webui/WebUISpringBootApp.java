package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forparkingcars.ForParkingCars;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class WebUISpringBootApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(WebUISpringBootApp.class).web(WebApplicationType.SERVLET).run(args);
    }

    @Bean
    public ForParkingCars carParker() {
        return ForParkingCarsWebUIDriver.carParker();
    }

}
