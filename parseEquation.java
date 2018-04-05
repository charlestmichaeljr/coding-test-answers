import java.io.*;
import java.util.*;
import javax.script.*;

/* 1b30 + 3b10 - 50 = sum the weight */

/* sum += <the_expression> 1b30 OR +3b10 OR -50

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */



class Solution {
  public static void main(String[] args) throws Exception {
    
    String input = "1b30 + 3b10 - 50";
    
    String[] tokens = input.split(" ");
    
    
    StringBuilder FullString = new StringBuilder("");
    
    for(int i = 0; i< tokens.length; i++) {
      
      String token = tokens[i];
      
      System.out.println(token);
        
        if(!token.equals("+") && !token.equals("-")) {
           Integer theWeight = determineWeightOfToken(token);
          FullString.append(theWeight.toString());
        }
        else
        {
          FullString.append(token);
        }
    }
                            
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine eng = mgr.getEngineByName("javascript");
    Integer answer = (Integer) eng.eval(FullString.toString());
    
    System.out.println(answer);
                            
  }
  
  public static Integer determineWeightOfToken(String token) {
    
    Integer result = 0;
    
    if(token.contains("b")) {
      String[] weightTokens = token.split("b");
      
      result =  Integer.parseInt(weightTokens[0]) * Integer.parseInt(weightTokens[1]);
    }
    else { 
      
      result = Integer.parseInt(token);
    }
    
    return result;
    
  }
}