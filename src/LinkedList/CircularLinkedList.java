package LinkedList;

public class CircularLinkedList {
    Node head;
    int size;
    class Node{
        Node next;
        int data;
        Node(int data){
            this.next=null;
            this.data = data;
        }
    }
    public void push(int data){
        Node n = new Node(data);
        if(head!=null) {
            Node temp = head;
            n.next = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = n;
            temp.next = n;
        }else {
            head = n.next = n;
        }
        size++;
    }
    public void append(int data){
        Node n =new Node(data);
        if(head==null){
            head = n;
            n.next = n;
        } else {
            Node temp = head;
            while(temp.next!=head){
                temp = temp.next;
            }
            temp.next = n;
            n.next = head;
        }
        size++;
    }
    public void traverse(){
        if(head==null){
            System.out.println("LinkedList is Empty");
        } else {
            Node temp = head;
            do {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }while (temp!=head);
            System.out.println();
        }
    }
    public void insertAt(int position,int data){
        if(position<1||position>(size+1)){
            System.out.println("You can insert from 1 to "+(size+1));
        } else {
            if(position==1){
                push(data);
            } else if (position==(size+1)) {
                append(data);
            } else {
                Node temp = head;
                Node n = new Node(data);
                for(int i=1;i<position-1;i++){
                    temp = temp.next;
                }
                n.next = temp.next;
                temp.next = n;
                size++;
            }
        }
    }
    public void delete(int position){
        if(head==null){
            System.out.println("Linked list is Empty");
        } else if (position<1||position>size) {
            System.out.println("You can delete from 1 to "+size);
        } else {
            Node temp = head;
            if(position==1){
                Node dN = head;
                while(temp.next!=head){
                    temp = temp.next;
                }
                head = dN.next;
                temp.next = head;
                dN.next = null;
            } else {
                for(int i=1;i<position-1;i++){
                    temp = temp.next;
                }
                Node dN = temp.next;
                temp.next = dN.next;
                dN.next=null;
            }
            size--;
        }
    }
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.traverse();

        cll.push(10);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.push(20);
        System.out.println("Size: " + cll.size);
        cll.traverse();

        cll.append(30);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.append(40);
        System.out.println("Size: " + cll.size);
        cll.traverse();

        cll.insertAt(1,50);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.insertAt(6, 60);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.insertAt(4, 70);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.insertAt(2, 80);
        System.out.println("Size: " + cll.size);
        cll.traverse();

        cll.delete(0);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.delete(1);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.delete(8);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.delete(1);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.delete(6);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.delete(5);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.delete(3);
        System.out.println("Size: " + cll.size);
        cll.traverse();
        cll.delete(2);
        System.out.println("Size: " + cll.size);
        cll.traverse();
    }
}
