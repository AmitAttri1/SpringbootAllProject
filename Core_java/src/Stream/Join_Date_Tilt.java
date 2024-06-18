package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Join_Date_Tilt {
	
	public static void main(String[] args) {
		
		String name="amit abhi ravi kavi attri";
		
		String[] split = name.split(" ");
		
	 String world = Arrays.stream(split)
				//.filter(c-> !c.isEmpty())
		.map(String :: toUpperCase)
		.sorted(Comparator.reverseOrder())
		.collect(Collectors.joining("~"));
	 System.out.println(world);
	 
		
	}

}
