package Stack;

public class StackImplementationUsingArray {
    int top;
    int[] a;
    int size;
    public StackImplementationUsingArray(int size){
        this.a= new int[size];
        this.size = size;
        this.top = -1;
    }
    public void push(int data){
        if(top==size-1){
            System.out.println("Stack is Full");
        } else {
            a[++top]=data;
        }
    }
    public int pop(){
        if(top==-1){
            System.out.println("Stack is empty");
            return -1;
        }
        System.out.println(a[top]+" is popped");
        return a[top--];
    }
    public int peek(){
        if(top==-1){
            System.out.println("Stack is Empty");
            return -1;
        }
        System.out.println(a[top]+" is peek element");
        return a[top];
    }
    public int size(){
        return a.length;
    }

    public static void main(String[] args) {
        StackImplementationUsingArray stack = new StackImplementationUsingArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.peek();
    }
}
