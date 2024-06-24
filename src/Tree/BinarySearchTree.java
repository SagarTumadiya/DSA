package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    static Node root;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    static void insert(int data){
        Node node = new Node(data);
        if(root==null){
            root = node;
        } else {
            Node temp = root;
            Queue<Node>q = new LinkedList<>();
            q.add(temp);
            while(!q.isEmpty()){
                temp = q.poll();
                if(temp.left==null && data<temp.data){
                    temp.left = node;
                } else if (temp.right==null && data>=temp.data){
                    temp.right = node;
                } else {
                    if(data>temp.data){
                        q.add(temp.right);
                    } else {
                        q.add(temp.left);
                    }
                }
            }
        }
    }
    static Node insertWrapper(Node root,int key){
        if(root==null){
            root = new Node(key);
            return root;
        } else if(key<root.data){
            root.left = insertWrapper(root.left,key);
        } else {
            root.right = insertWrapper(root.right,key);
        }
        return root;
    }
    static void recursiveInsert(int key){
        root = insertWrapper(root,key);
    }
    static void levelorderTraversal(){
        if(root==null){
            System.out.println("Tree is Empty");
        } else {
            Queue<Node>q = new LinkedList<>();
            Node temp = root;
            q.add(temp);
            while (!q.isEmpty()){
                temp = q.poll();
                System.out.print(temp.data+" ");
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        recursiveInsert(9);
        recursiveInsert(8);
        recursiveInsert(7);
        recursiveInsert(5);
        recursiveInsert(3);
        recursiveInsert(4);
        recursiveInsert(2);
        recursiveInsert(1);
        recursiveInsert(3);
        recursiveInsert(10);
        recursiveInsert(5);
        recursiveInsert(9);
        levelorderTraversal();

    }
}
