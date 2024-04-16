package com.fouad.exemple;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello  From Controller";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message){
        return "Request accepted an message : "+message;
    }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order){
        // Use Setters and Getters
        return "Request accepted an order : "+order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(@RequestBody OrderRecord order){
        return "Request accepted an order : "+order.toString();
    }


}
