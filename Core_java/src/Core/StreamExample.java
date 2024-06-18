package Core;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        String input = "6500100309";
        
        //String result = String.valueOf(input);to covert the value into string
        
        List<String>numericList =new ArrayList<>();
        List<String>zeroList =new ArrayList<>();
        
        for (char c : input.toCharArray()) {
            if (c == '0') {
                zeroList.add(String.valueOf(c));
            } else {
                numericList.add(String.valueOf(c));
            }
        }
       
        // Print the lists
        List<String>combined =new ArrayList<>();
        
        combined.addAll(zeroList);
        combined.addAll(numericList);
        //System.out.println("Numeric List: " + numericList);
        //System.out.println("Zero List: " + zeroList);
        System.out.println(combined);
    }
}
