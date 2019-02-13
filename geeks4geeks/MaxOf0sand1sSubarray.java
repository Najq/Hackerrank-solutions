{
    /*You are required to complete this method*/ 
    int maxLen(int[] arr) 
    {
         HashMap<Integer, Integer> hm= new HashMap<Integer,Integer>();
         int sum =0;
         int max_len =0;
         for(int i=0;i<arr.length;i++){
             if(arr[i] == 0){
                 sum += -1;
             }
             else
             sum += arr[i];
             
             if(sum == 0){
                 max_len = i+1;
             }
             
             Integer prev_i = hm.get(sum);
             
             if(prev_i != null){
                 max_len = Math.max(max_len, i - prev_i);
             }else{
                 hm.put(sum,i);
             }
         }
         
         return max_len;
         
    }
}