/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author root
 */
public class Calculator {
    
    private String input;
    
    public Calculator(String input){
        this.input = input;
    }
    
    public Calculator(){
    
    }
    
    private String[] toArrayElements(String expressionString){
        
        String temp = "";
        
        // Pre-processing
        expressionString = expressionString.trim();
        expressionString = expressionString.replace("\\s+", " ");
        for(int i = 0; i<expressionString.length(); ++i){
            char c = expressionString.charAt(i);
            if(isOperator(c)){
                temp = temp + " " + c  + " ";
            }
            else{
                temp = temp + c;
            }
        }
        temp = temp.trim();
        temp = temp.replaceAll("\\s+"," ");
        String[] ret = temp.split(" ");
        
        return ret;
    }
    
    public String[] infixToPostfix(String[] infixArray){
        ArrayList<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i<infixArray.length; ++i){
            String currentElement = infixArray[i];
            if(!isOperator(currentElement)){
                output.add(currentElement);
            }
            else if(currentElement.equals("(")){
                stack.push(currentElement);
            }
            else if(currentElement.equals(")")){
                while(!stack.empty()){
                    String popElement = stack.pop();
                    
                    // pop element out of stack until meet "("
                    if(popElement.equals("(")){
                        break;
                    }
                    
                    // add to output
                    output.add(popElement);
                }
            }
            else {  
                while (!stack.empty() && getPriority(stack.peek()) > getPriority(currentElement) ) {
                    String popElement = stack.pop();
                    output.add(popElement);
                }

                // Push current element into stack
                stack.push(currentElement);
            }
        }
        // Check if stack have more elements
        while (!stack.empty()) {
            String popElement = stack.pop();
            output.add(popElement);
        }
        return (output.toArray(new String[output.size()]));
    }
    
    private boolean isOperator(char element){
        switch(element){
            case '+':
            case '-':
            case '*':
            case '/':
            case '(':
            case ')':
                return true;
            default:
                return false;
        }
    }
    
    
    private int getPriority(char operator){
        switch(operator){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }
    
    private int getPriority(String operator){
        return getPriority(operator.charAt(0));
    }
    
    private boolean isOperator(String element){
        return isOperator(element.charAt(0));
    }
    
    public String calc(){
        String[] arrayElements = toArrayElements(this.input);
        String[] postfix = infixToPostfix(arrayElements);
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < postfix.length; i++){
            
            if(!isOperator(postfix[i])){
                stack.push(postfix[i]);
            }else{
                Long num1 = Long.valueOf(stack.pop());
                Long num2 = Long.valueOf(stack.pop());
                
                stack.push(execute(num2,num1,postfix[i]));
            }
        }
        return stack.pop();
    }
    
    private String execute(Long num1,Long num2,String operator){
        Long res = 0L;
        switch(operator){
            case "+":
                res = num1+num2;
                break;
            case "-":
                res = num1-num2;
                break;
            case "*":
                res = num1*num2;
                break;
            case "/":
                res = num1/num2;
                break;
        }
        return String.valueOf(res);
    }
}
