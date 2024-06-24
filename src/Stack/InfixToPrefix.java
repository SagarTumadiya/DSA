package Stack;

import java.util.Stack;

public class InfixToPrefix {

    static void reverse(char[] a){
        int n = a.length;
        for(int i=0;i<n/2;i++){
            char temp = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = temp;
        }
    }
    static int prec(char c){
        if(c=='^')
            return 3;
        else if (c=='/'||c=='*') {
            return 2;
        } else if (c=='+'||c=='-') {
            return 1;
        }
        return -1;
    }
    static String convertToPostfix(String infix){
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(int i=0;i<infix.length();i++){
            char c=infix.charAt(i);
            if((c>='a'&& c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))
                postfix.append(c);
            else if (c=='(') {
                stack.push(c);
            } else if (c==')') {
                while (!stack.isEmpty()&&stack.peek()!='(')
                    postfix.append(stack.pop());

                stack.pop();
            } else {
                while (!stack.isEmpty() &&
                        ( prec(c)<prec(stack.peek())||
                                (prec(c)<=prec(stack.peek()) && c=='^')
                        )
                )
                    postfix.append(stack.pop());

                stack.push(c);
            }

        }
        while (!stack.isEmpty())
            postfix.append(stack.pop());
        return postfix.toString();
    }
    static String convertToPrefix(String infix){
        char[] a = infix.toCharArray();
        reverse(a);
        for(int i=0;i<a.length;i++){
            if(a[i]=='(')
                a[i]=')';
            else if (a[i]==')') {
                a[i]='(';
            }
        }
        String prefix = convertToPostfix(String.valueOf(a));
        char[] postfix = prefix.toCharArray();
        reverse(postfix);

        return String.valueOf(postfix);
    }

    public static void main(String[] args) {
        String exp = "((a+b)^c)^d";

        // Function call
        System.out.println(convertToPrefix(exp));
    }

}
