package com.jojo.NumberRecognitionAPI.Webrest.endpoints;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"numberrecognition/v1/rest/service/"})
@CrossOrigin
public interface IRestController {
  @GetMapping({"/status"})
  ResponseEntity<String> status(HttpServletRequest paramHttpServletRequest);
  
  //AdminPanel User System
  @GetMapping({"/ki/askai"})
  ResponseEntity<String> askai(HttpServletRequest paramHttpServletRequest, String image);
  
  @GetMapping({"/data/randomimg"})
  ResponseEntity<String> getrandomimg(HttpServletRequest paramHttpServletRequest);
  
} 