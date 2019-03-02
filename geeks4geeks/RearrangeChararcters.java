import java.io.*; 
import java.util.*; 
  
  
class KeyComparator implements Comparator<Key>{
    
    public int compare(Key k1, Key k2){
        
        if(k1.freq > k2.freq)
            return -1;
        if(k1.freq < k2.freq)
           return 1;
       return 0;
    }
    
}

class Key{
    int freq;
    char ch;
    Key(int val, char c){
        freq=val;
        ch=c;
    }
}

class MainDriver{
    
    static int MAX_CHAR =26;
    
    static void rearrangeString(String str){
        int n =str.length;
        int[] count = new int[MAX_CHAR];
        for(i=0;i<n;i++)
            count[str.chartAt[i] - 'a']++;
        
        PriorityQueue<Key> pq =new PriorityQueue<>(new KeyComparator);
        for(char c='a';c<='z';c++){
            int value=  c- 'a';
            if(count[value] > 0){
                pq.add(new Key(count[value],c));
                
            }
        }
        
        str="";
        
        Key prev = new Key(-1, '#');
        
        
        while(pq.size() !=0 ){
            
            Key k= pq.peek();
            pq.poll();
            str += k.ch;
            
            if(prev.freq > 0)
                pq.add(prev);
                
            (k.freq) --;
            
            prev = k;          
        }
        
        if(n != str.length)
            System.out.println("Not a valid string");
        else
            System.out.println(str);        
        
    }
    
    public static void main(String args[]){
        
        String str ="aaabc";
        rearrangeString(str);
    }
    
}