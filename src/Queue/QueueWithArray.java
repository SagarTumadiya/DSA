package Queue;

public class QueueWithArray {
    int front;
    int rear;
    int []a;
    int size;
    QueueWithArray(int size){
        a = new int[size];
        this.size = size;
        this.front = -1;
        this.rear  = -1;
    }
    void print(){
        if(front==-1){
            System.out.println("Queue is Empty");
            return;
        }
        if(rear<front){
            for(int i=front;i<size;i++)
                System.out.print(a[i]+" ");
            for(int i=0;i<=rear;i++)
                System.out.print(a[i]+" ");
        }else {
            for(int i=front;i<=rear;i++)
                System.out.print(a[i]+" ");
        }

        System.out.println();
    }
    boolean isEmpty(){
        return (front==-1 || front>rear);
    }
    boolean isFull(){
        return ((rear==size-1&&front==0) || rear==front-1);
    }
    void push(int n){
        if(front==-1){
            front = 0;
            rear = 0;
            a[0] = n;
            return;
        } else if((front==0&& rear==size-1)||(front==rear+1)){
            System.out.println("Queue is Full");
            return;
        } else if (rear==size-1 && front>0) {
            rear = 0;
            a[0] = n;
        } else {
         a[++rear] = n;
        }
    }
    int pop(){
        if(front == -1){
            System.out.println("Queue is Empty");
            return -1;
        } else if (front==rear) {
            int p = a[front];
           front=rear=-1;
           return p;
        } else if (front==size-1) {
            front = 0;
            return a[size-1];
        } else {
            return a[front++];
        }

    }
    public static void main(String[] args) {
        QueueWithArray queue = new QueueWithArray(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.print();
        System.out.println("pooped element is "+queue.pop());
        System.out.println("pooped element is "+queue.pop());
        queue.print();
        queue.push(6);
        queue.push(7);
        queue.push(8);
        queue.print();
        System.out.println("pooped element is "+queue.pop());
        queue.print();
        System.out.println("pooped element is "+queue.pop());
        queue.print();
        System.out.println("pooped element is "+queue.pop());
        System.out.println("pooped element is "+queue.pop());
        System.out.println("pooped element is "+queue.pop());
        queue.print();

    }
}
