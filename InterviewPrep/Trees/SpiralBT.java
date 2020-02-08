import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

class SpiralBT{

    static Node root;
    
    void printTraversal(Node node){

        if(node == null){
            return;
        }

        Stack<Node> s1 = new Stack<Node>(); 
        Stack<Node> s2 = new Stack<Node>(); 

        s1.push(node);

        while(!s1.isEmpty() || !s2.isEmpty()){

            while(!s1.isEmpty()){
                Node temp = s1.pop();

                System.out.print(temp.data + " "); 

                if(temp.right != null){
                    s2.push(temp.right);
                }

                if(temp.left != null){
                    s2.push(temp.left);
                }
                
            }
            while(!s2.isEmpty()){
                Node temp = s2.pop();

                System.out.print(temp.data + " "); 

                if(temp.left != null){
                    s1.push(temp.left);
                }
                if(temp.right != null){
                    s1.push(temp.right);
                }
            }
        }
    }

    public static void main(String[] args){

        SpiralBT tree = new SpiralBT(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(7); 
        tree.root.left.right = new Node(6); 
        tree.root.right.left = new Node(5); 
        tree.root.right.right = new Node(4); 
        System.out.println("Spiral Order traversal of Binary Tree is "); 
        tree.printTraversal(root); 

    }
}