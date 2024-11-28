package com.curso.api.start.Controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.api.start.Ola;

@RestController
public class OlaController {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/Ola")
    public Ola ola(@RequestParam(value = "nome", defaultValue = "World") String nome){
        return new Ola(counter.incrementAndGet(), String.format(template, nome));
    }

}
