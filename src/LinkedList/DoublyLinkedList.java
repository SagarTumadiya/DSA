package LinkedList;

public class DoublyLinkedList {
    Node head;
    int size;
    class Node{
        Node prev;
        Node next;
        int data;
        Node(int data){
            this.prev = null;
            this.next = null;
            this.data = data;
        }
    }
public void append(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
        }else {
            Node temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
        size++;
}
public void push(int data){
    Node n = new Node(data);
    n.next = head;
    if(head != null) {
        head.prev = n;
    }
    head = n;

    size ++;
}
public void traverse(){
        if(head == null){
            System.out.println("Linked list is Empty");
        } else {
            Node currentNode = head;
            while(currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
}
public void insertAt(int data,int position){

        if(position<1||position>(size+1)){
            System.out.println("You can insert from 1 to "+(size+1));
        }else {

            if(position==1){
                push(data);
            } else if (position==size+1) {
                append(data);
            } else {
                Node temp = head;
                for(int i=1;i<position-1;i++){
                    temp = temp.next;
                }
                Node n = new Node(data);
                n.next =temp.next;
                n.prev = temp;
                temp.next.prev = n;
                temp.next = n;
                size++;
            }

        }

}
public void delete(int position){
        if(head==null){
            System.out.println("Linked list is Empty");
        }else if(position<1||position>size) {
            System.out.println("You can delete from 1 to "+size);
        } else {
            Node temp = head;
            if(position==1){
                temp.next.prev = null;
                head = temp.next;
                temp.next = null;
            } else {

                for(int i=1;i<position-1;i++){
                    temp = temp.next;
                }
                Node dN = temp.next;
                if(position==size){
                    temp.next = dN.prev = null;

                }else {
                    temp.next = dN.next;
                    temp.next.prev = temp;
                    dN.next=dN.prev = null;
                }
            }
            size--;
        }
}
    public static void main(String[] args) {
        DoublyLinkedList l = new DoublyLinkedList();
        System.out.println("Size: " + l.size);
        l.push(1);
        System.out.println("Size: " + l.size);
        l.traverse();
        l.push(2);
        System.out.println("Size: " + l.size);
        l.traverse();
        l.append(3);
        System.out.println("Size: " + l.size);
        l.traverse();
        l.delete(2);
        System.out.println("Size: " + l.size);
        l.traverse();
        l.push(5);
        System.out.println("Size: " + l.size);
        l.traverse();
        l.insertAt(6,2);
        System.out.println("Size: " + l.size);
        l.traverse();
        l.insertAt(1,3);
        System.out.println("Size: " + l.size);
        l.traverse();
        l.insertAt(9,6);
        System.out.println("Size: " + l.size);
        l.traverse();
    }
}
