package com.hyundai.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 		: 고석준, 황명하 
 * @fileName 	: HomeController.java
 * @date 		: 2022. 5. 17.
 * @description : /로 들어오는 요청에 대해서 /board/list화면으로 처리함 
 */
@Controller
public class HomeController {

   @GetMapping("/")
   public String home(){
       return "redirect:/board/list";
   }//end hello

}//end class
