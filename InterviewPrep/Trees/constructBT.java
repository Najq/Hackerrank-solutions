import java.io.*;

class Node{ 
    int data; 
    Node left, right;
    Node(int d){ 
        data = d; 
        left = right = null; 
    } 
} 
  
class Index{ 
    int index = 0; 
} 

class constructBT{

    Index index = new Index();

    Node constructTree(int pre[],Index preIndex,int key, int min, int max, int size){

        if(preIndex.index > size){
            return null;
        }

        Node root = null;

        if(key > min && key < max){
            root = new Node(key);
            preIndex.index +=1;
            
            if(preIndex.index < size){
                root.left = constructTree(pre, preIndex, pre[preIndex.index], min, key, size);
                
                root.right = constructTree(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }
        return root;
    }

    Node startConstructTree(int[] pre, int size){
        int preIndex = 0; 
        return constructTree(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size); 
    }

    void printInorder(Node node){ 
        if (node == null) { 
            return; 
        } 
        printInorder(node.left); 
        System.out.print(node.data + " "); 
        printInorder(node.right); 
    } 

    public static void main(String[] args){ 
        constructBT tree = new constructBT(); 
        int pre[] = new int[]{10, 5, 1, 7, 40, 50}; 
        int size = pre.length; 
        Node root = tree.startConstructTree(pre, size); 
        System.out.println("Inorder traversal of the constructed tree is "); 
        tree.printInorder(root); 
    } 
}