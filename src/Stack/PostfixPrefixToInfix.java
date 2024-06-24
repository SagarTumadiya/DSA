package Stack;

import java.util.Stack;

public class PostfixPrefixToInfix {
    static boolean isOperator(char c){
        return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }
    static String prefixToInfix(String prefix){
        Stack<String>stack = new Stack<>();
        for(int i=prefix.length()-1;i>=0;i--){
            char c = prefix.charAt(i);
            if(isOperator(c)){
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("("+op1+c+op2+")");

            } else {
                stack.push(c+"");
            }
        }
        return stack.peek();
    }
    static String postfixToInfix(String postfix){
        Stack<String>stack = new Stack<>();
        for(int i=0;i<postfix.length();i++){
            char c = postfix.charAt(i);
            if(isOperator(c)){
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("("+op2+c+op1+")");

            } else {
                stack.push(c+"");
            }
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        System.out.println(postfixToInfix("ab+c^d^"));
        System.out.println(prefixToInfix("^^+abcd"));
    }
}
