package com.spring.rest.fom.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = "com.spring.rest.fom.controller.web") 
public class HtmlExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleNotFound(ResourceNotFoundException ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorMessage", ex.getMessage());
        return mv;
    }

    @ExceptionHandler(Exception.class) // fallback za sve ostale greške
    public ModelAndView handleGeneralError(Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorMessage", "Došlo je do greške: " + ex.getMessage());
        return mv;
    }
}
