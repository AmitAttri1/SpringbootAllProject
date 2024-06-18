package Core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DuplcateArray {

	public static void main(String[] args) {
		
		Set<String>arraylist=new HashSet<>();
		arraylist.add("A");
		arraylist.add("A");
		arraylist.add("m");
		arraylist.add("i");
		arraylist.add("t");
		
		Iterator<String> iterator = arraylist.iterator();
		
		while(iterator.hasNext())
		{
			String next = iterator.next();
			System.out.println(next);
		}
		
		
		
	
	}
}
