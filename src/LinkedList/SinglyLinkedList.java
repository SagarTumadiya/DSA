package LinkedList;

import javax.naming.NoPermissionException;

public class SinglyLinkedList {
    Node head;
    int size;
    class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void append(int data){
        Node n = new Node(data);

        if(head==null){
            head = n;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = n;

        }
        size++;
    }
    public void push(int data){
        Node n = new Node(data);
        if(head!=null){
            n.next = head;
        }
        head = n;
        size++;
    }
    public void traverse(){
        if(head==null){
            System.out.println("Linked List is Empty");
        } else {
            Node currentNode = head;
            while(currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
    }
    public void insertAt(int position,int data){
        if(position<1||position>(size+1)){
            System.out.println("You can only choose position from 1 to "+(size+1));
        }else{
            if(position==1){
                push(data);
            }else if(position ==size+1){
                append(data);
            }
            else {
                Node temp = head;
                for(int i=1;i<position-1;i++){
                    temp = temp.next;
                }
                Node n = new Node(data);
                n.next = temp.next;
                temp.next = n;
                size++;
            }
        }
    }
    public void delete(int position){
        if(head==null){
            System.out.println("LinkedList is Empty");
        } else if(position>size || position<1){
            System.out.println("You can only choose position from 1 to "+size);
        } else {
            Node temp = head;
            if(position==1){
                head = temp.next;
                temp.next = null;
            }else {
                for (int i=1;i<position-1;i++){
                    temp = temp.next;
                }
                Node Dn = temp.next;
                temp.next = Dn.next;
                Dn.next = null;
            }
            size--;
        }
    }
    public static void main(String[] args) {
      SinglyLinkedList l = new SinglyLinkedList();
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
        l.insertAt(5,6);
        System.out.println("Size: " + l.size);
        l.traverse();
    }
}
