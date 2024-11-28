package com.curso.api.start;

public class Operations{
    
    public Double sum( Double numberOne,Double numberTwo){        
        return numberOne + numberTwo;
                
    }
    
    public Double sub( Double numberOne,  Double numberTwo){
        
        return  numberOne - numberTwo;               
    }
   
    public Double mult( Double numberOne,  Double numberTwo){
        
        return  numberOne * numberTwo;
                
    }
    
    public Double div( Double numberOne,  Double numberTwo){
        
        return  numberOne / numberTwo;
                
    }
    
    public Double med( Double numberOne,  Double numberTwo){
        
        return (numberOne + numberTwo) / 2;
               
    }

    public Double raiz( Double number){
        
        return  Math.sqrt(number);
               
    }

}
