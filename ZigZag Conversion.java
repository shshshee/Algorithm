import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        
        String output = ""; 
    
        int depth = 1; 
        int index = 0;
        
        if(numRows == 1 || s.length() <2){
            return s;
        }
        
        while(s.length()>=depth){
                                            
            output += Character.toString(s.charAt(index));
            
            if(depth >1 && depth < numRows){
                index += 2*(numRows-depth);
                if(index < s.length()){
                    output += Character.toString(s.charAt(index));
                }
                index += 2*(depth-1);
            }else{
                index += 2*(numRows-1);
            }
                  
            if(index>s.length()-1){
                depth++;
                if(depth>numRows)break;
                index = depth-1; 
            }
            
        }
             
        return output; 
        
    }
}