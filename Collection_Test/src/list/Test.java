package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		
	
	
	Integer [] intarray= {1,2,3,4,2,4};
	
	List<Integer> asList = Arrays.asList(intarray);
	 List<Integer> duplicate = asList.stream()
	 .filter(i->asList.indexOf(i)!=asList.lastIndexOf(i))
	 .distinct()
	 .collect(Collectors.toList());
	 
	 System.out.println(duplicate);
	
	
	
	}
	}



