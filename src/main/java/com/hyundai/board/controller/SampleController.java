package com.hyundai.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

   @GetMapping("/hello")
   public String[] hello(){
       return new String[]{"hello","wolrd"};
   }//end hello

}//end class
