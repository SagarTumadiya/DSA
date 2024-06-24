package Stack;

import java.util.Stack;

public class PostfixToPrefix {
    static boolean isOperator(char c){
        return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }
    static String convertToPrefix(String postfix){
        Stack<String>stack = new Stack<>();

        for(int i=0;i<postfix.length();i++){
            char c = postfix.charAt(i);
            if(isOperator(c)){
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(c+op2+op1);
            } else {
                stack.push(c+"");
            }
        }

        return stack.peek();
    }
    public static void main(String[] args) {
        System.out.println(convertToPrefix("ab+c^d^"));
    }
}
