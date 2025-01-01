package com.convert.demo.controller;
import com.convert.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller; 

@Controller
public class HomeController {

    @Autowired
      private ConverterService converterService;
    
  
    @RequestMapping("/") 
     public ModelAndView home() {
         ModelAndView mv = new ModelAndView();
         mv.setViewName("index.jsp");
         try {
         converterService.addCountryInfo(mv);
         } catch(Exception e) { e.printStackTrace(); }
         
         return mv;
     }
    @RequestMapping("/convert")
     public ModelAndView convert(String from , String to, String amount) {
          ModelAndView mv = new ModelAndView();
          try {
          converterService.addCountryInfo(mv);
          converterService.convertAmount(from,to,amount,mv);
          } catch( Exception e )  { e.printStackTrace(); }
          mv.setViewName("index.jsp");
          return mv;
     }

}