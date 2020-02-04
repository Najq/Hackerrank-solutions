import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {

        if(root == null){
            return;
        }

        Queue<Node> queueList = new LinkedList<>();
        queueList.add(root);

        while(!queueList.isEmpty()){

            Node currNode = queueList.poll();

            System.out.print(currNode.data+" ");

            if(currNode.left != null){
                queueList.add(currNode.left);
            }
            
            if(currNode.right != null){
                queueList.add(currNode.right);
            }
        }
    }

	public static Node insert(Node root, int data) {