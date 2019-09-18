package io.clue2solve.springk8s.controllers;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
public class GreetingsController {
    @Value("${greeting:Hola}")
    private String dispGreeting;
    @Value("${name:Friend}")
    private String dispName;

    @RequestMapping( method = RequestMethod.GET , value = { "/greet"  } )
    public String hello(@RequestParam (required = false) String greeting , @RequestParam(required = false) String name){

        if (! ( greeting == null || greeting.isEmpty()) )setDispGreeting(greeting);
        if (! ( name == null ||  name.isEmpty())) setDispName(name);
        
        return dispGreeting + " " + dispName;
    }

}

