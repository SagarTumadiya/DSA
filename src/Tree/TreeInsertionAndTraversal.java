package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeInsertionAndTraversal {
    static Node root;

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
        this.data = data;
        this.left = this.right = null;
        }
    }
        static void insert(int key){
            Node node = new Node(key);
            if(root==null){
                root = node;
            } else {
                Node temp = root;
                Queue<Node>tree = new LinkedList<>();
                tree.add(temp);
                while (!tree.isEmpty()){
                    temp = tree.poll();
                    if(temp.left==null){
                        temp.left = node;
                        break;
                    } else {
                        tree.add(temp.left);
                    }
                    if(temp.right==null){
                        temp.right = node;
                        break;
                    } else {
                        tree.add(temp.right);
                    }
                }
            }
        }
        static void inorderTraversal(Node temp){
            if(root==null){
                System.out.println("Tree is Empty");
            } else if (temp==null) {

            } else {
                inorderTraversal(temp.left);
                System.out.print(temp.data+" ");
                inorderTraversal(temp.right);
            }

        }
        static void preorderTraversal(Node temp){
            if(root==null){
                System.out.println("Tree is Empty");
            } else if (temp==null) {

            } else {
                System.out.print(temp.data+" ");
                preorderTraversal(temp.left);
                preorderTraversal(temp.right);
            }

        }
        static void postorderTraversal(Node temp){
            if(root==null){
                System.out.println("Tree is Empty");
            } else if (temp==null) {

            } else {
                postorderTraversal(temp.left);
                postorderTraversal(temp.right);
                System.out.print(temp.data+" ");
            }

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
        TreeInsertionAndTraversal.insert(1);
        TreeInsertionAndTraversal.insert(2);
        TreeInsertionAndTraversal.insert(3);
        TreeInsertionAndTraversal.insert(4);
        TreeInsertionAndTraversal.insert(5);
        TreeInsertionAndTraversal.insert(6);
        TreeInsertionAndTraversal.insert(7);
        TreeInsertionAndTraversal.insert(8);
        TreeInsertionAndTraversal.insert(9);
        TreeInsertionAndTraversal.inorderTraversal(root);
        System.out.println();
        TreeInsertionAndTraversal.preorderTraversal(root);
        System.out.println();
        TreeInsertionAndTraversal.postorderTraversal(root);
        System.out.println();
        TreeInsertionAndTraversal.levelorderTraversal();
    }
}
