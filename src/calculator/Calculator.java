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
    private Integer num1;
    private Integer num2;
    private String operator = null;
    
    public Calculator(String input){
        String[] param = null;
        
        if(input.contains("+")){
            operator = "+";
            param = input.split("+");
        }
        else if(input.contains("-")){
            operator = "-";
            param = input.split("-");
        }
        else if(input.contains("*")){
            operator = "*";
            param = input.split("*");
        }
        else if(input.contains("/")){
            operator = "/";
            param = input.split("/");
        }
        
        if(param != null){
            num1 = Integer.parseInt(param[0].trim());
            num2 = Integer.parseInt(param[1].trim());
        }
        else{
            num1 = Integer.parseInt(input);
        }
    }
    
    public String calc(){
        
        if(operator == null){
            return num1.toString();
        }
        
        else{
            switch(operator){
                case "+":
                    return String.valueOf(num1+num2);
                case "-":
                    return String.valueOf(num1-num2);
                case "*":
                    return String.valueOf(num1*num2);
                case "/":
                    return String.valueOf(num1/num2);
            }
        }
        return null;
    }
}
