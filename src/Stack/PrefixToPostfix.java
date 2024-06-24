package Stack;

import java.util.Stack;

public class PrefixToPostfix {
    static boolean isOperator(char c){
        return(c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }
    static String convertToPostfix(String prefix){
        Stack<String>stack=new Stack<>();
        for (int i = prefix.length()-1; i>=0 ; i--) {
            char c = prefix.charAt(i);
            if(isOperator(c)){
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(op1+op2+c);
            } else {
                stack.push(c+"");
            }

        }
        return stack.peek();
    }
    public static void main(String[] args) {
        System.out.println(convertToPostfix("^^+abcd"));
    }
}
