package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
// import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import java.util.ServiceLoader;

@SpringBootApplication
public class ForParkingCarsWebUIAdapter {

    public static void main(String[] args) {
//        SpringApplication.run(ForParkingCarsWebUIAdapter.class, args);
        new SpringApplicationBuilder(ForParkingCarsWebUIAdapter.class).web(WebApplicationType.SERVLET).run(args);
    }

    @Bean
    public ForParkingCars carParker() {
        return ServiceLoader.load(ForParkingCarsGetter.class).findFirst().get().getCarParker();
    }

    @Bean
    public FileTemplateResolver secondaryTemplateResolver() {
        FileTemplateResolver secondaryTemplateResolver = new FileTemplateResolver();
        secondaryTemplateResolver.setPrefix("/home/jmgarrido/Escritorio/ProyectosWeb/github/bluezone/src/bluezone-adapter-forparkingcars-webui/src/main/resources/templates/");
        secondaryTemplateResolver.setSuffix(".html");
        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
        secondaryTemplateResolver.setOrder(1);
        secondaryTemplateResolver.setCheckExistence(true);

        return secondaryTemplateResolver;
    }

}
