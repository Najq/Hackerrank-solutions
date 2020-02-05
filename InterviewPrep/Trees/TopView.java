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
	public static void topView(Node root) {

        Map<Integer, Node> hdMap = new TreeMap<Integer,Node>();
        class QueueObj{
            Node node;
            int hd;
            QueueObj(Node node,int hd){
                this.node = node;
                this.hd = hd;
            }

        }

        if(root == null){
            return;
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>(); 
        q.add(new QueueObj(root, 0));

        while(!q.isEmpty()){
            QueueObj tempQ = q.poll(); 
            if(!hdMap.containsKey(tempQ.hd)){
                hdMap.put(tempQ.hd,tempQ.node);
            }
            if(tempQ.node.left != null){
                q.add(new QueueObj(tempQ.node.left,tempQ.hd-1));
            }
            if(tempQ.node.right != null){
                q.add(new QueueObj(tempQ.node.right,tempQ.hd+1));
            }
        }
        for(Map.Entry<Integer,Node> entry: hdMap.entrySet()){
            System.out.print(entry.getValue().data+" ");
        }

    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}