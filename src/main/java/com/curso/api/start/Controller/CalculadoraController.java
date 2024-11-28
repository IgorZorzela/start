package com.curso.api.start.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.api.start.Operations;
import com.curso.api.start.Verifications;

import com.curso.api.start.Exceptions.UnsupportedMath;

@RestController
public class CalculadoraController { 

    private  Operations math = new Operations();
    //private static final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!Verifications.isNumeric(numberOne) || !Verifications.isNumeric(numberTwo)) {
            throw new UnsupportedMath("Please set a numeric value!");
        }
        return math.sum(Verifications.covertToDouble(numberOne) , Verifications.covertToDouble(numberTwo));                 
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!Verifications.isNumeric(numberOne) || !Verifications.isNumeric(numberTwo)) {
            throw new UnsupportedMath("Please set a numeric value!");
        }
        return math.sub(Verifications.covertToDouble(numberOne) , Verifications.covertToDouble(numberTwo));        
    }

    @RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!Verifications.isNumeric(numberOne) || !Verifications.isNumeric(numberTwo)) {
            throw new UnsupportedMath("Please set a numeric value!");
        }
        return math.mult(Verifications.covertToDouble(numberOne) , Verifications.covertToDouble(numberTwo));       
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!Verifications.isNumeric(numberOne) || !Verifications.isNumeric(numberTwo)) {
            throw new UnsupportedMath("Please set a numeric value!");
        }
        return math.div(Verifications.covertToDouble(numberOne) , Verifications.covertToDouble(numberTwo));        
    }

    @RequestMapping(value="/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!Verifications.isNumeric(numberOne) || !Verifications.isNumeric(numberTwo)) {
            throw new UnsupportedMath("Please set a numeric value!");
        }
        return math.med(Verifications.covertToDouble(numberOne) , Verifications.covertToDouble(numberTwo));       
    }

    @RequestMapping(value="/raiz/{number}", method=RequestMethod.GET)
    public Double raiz(@PathVariable("number") String number) throws Exception {
        if (!Verifications.isNumeric(number)) {
            throw new UnsupportedMath("Please set a numeric value!");
        }
        return math.raiz(Verifications.covertToDouble(number));
    }

}