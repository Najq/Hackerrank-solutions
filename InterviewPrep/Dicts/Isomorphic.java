// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean isIsomorphic(String input1, String input2) {
    
    Map<Character,Integer> str1_map = new HashMap<>();
    Map<Character,Integer> str2_map = new HashMap<>();
    
    
    for(char ch:input1.toCharArray()){
        if(!str1_map.containsKey(ch)){
            str1_map.put(ch,1);
        }
        str1_map.put(ch,str1_map.get(ch)+1);
    }
    for(char ch:input2.toCharArray()){
        if(!str2_map.containsKey(ch)){
            str2_map.put(ch,1);
        }
        str2_map.put(ch,str2_map.get(ch)+1);
    }
    if(str1_map.size() == str2_map.size() && (input2.length() == input1.length())){
        return true;
    }
    
    return false;
    
    
    
    
}