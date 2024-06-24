package Stack;

import java.util.Stack;

public class InfixToPostfix {
     static int pre(char c){
       if(c=='^') {
           return 3;
       } else if(c=='/'||c=='*'){
           return 2;
       }
       else if (c=='+'||c=='-') {
           return 1;
       }
       return -1;
    }
   static char associativity(char c){
        if(c=='^')
            return 'R';
        else
            return 'L';
    }
    static String convertToPostfix(String infix){
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for(int i=0;i<infix.length();i++){
            char c = infix.charAt(i);
            if((c>='a' && c<='z' )||(c>='A' && c<='Z')||(c>='0'&& c<='9')){
                postfix.append(c);
            }
            else if(c=='('){
                stack.push(c);
            } else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && (pre(c)<pre(stack.peek()) || pre(c)==pre(stack.peek()) && associativity(c)=='L')){
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            postfix.append(stack.pop());

        return postfix.toString();
    }
    public static void main(String[] args) {
        String exp = "((a+b)^c)^d";

        // Function call
        System.out.println(convertToPostfix(exp));
    }
}
