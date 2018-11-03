/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author root
 */
public class Calculator {
    private Float num1;
    private Float num2;
    private String operator = null;
    
    public Calculator(String input){
        String[] param = null;
        
        if(input.contains("+")){
            operator = "+";
            param = input.split("\\+");
        }
        else if(input.contains("-")){
            operator = "-";
            param = input.split("-");
        }
        else if(input.contains("*")){
            operator = "*";
            param = input.split("\\*");
        }
        else if(input.contains("/")){
            operator = "/";
            param = input.split("/");
        }
        
        if(param != null){
            num1 = Float.parseFloat(param[0].trim());
            num2 = Float.parseFloat(param[1].trim());
        }
        else{
            num1 = Float.parseFloat(input);
        }
    }
    
    public String calc(){
        
        Float res = 0f;
        
        if(operator == null){
            return num1.toString();
        }
        
        else{
            switch(operator){
                case "+":
                    res = num1+num2;
                case "-":
                    res = num1-num2;
                case "*":
                    res = num1*num2;
                case "/":
                    res = num1/num2;
            }
            if(res.floatValue() == (float)Math.round(res)){
                return String.valueOf(Math.round(res));
            }
            else
                return String.valueOf(res);
        }
    }
}
