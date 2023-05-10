//package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;
//
//import io.github.jmgarridopaz.bluezone.hexagon.PayErrorException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @Autowired
//    private Environment environment;
//
//
//    @ExceptionHandler(Exception.class)
//    public String handleException (Model model, Exception exception ) {
//        String exceptionName = exception.getClass().getSimpleName();
//        String errorMessage = exceptionMessageToShow ( exceptionName );
//        model.addAttribute ("errorMessage", errorMessage );
//        return "error";
//    }
//
//    private String exceptionMessageToShow ( String exceptionName ) {
//        String exceptionMessage = this.environment.getProperty ( exceptionName );
//        if ( exceptionMessage==null ) {
//            return  "An unexpected error occurred. Contact the application administrator";
//        }
//        return exceptionMessage;
//    }
//
//}a