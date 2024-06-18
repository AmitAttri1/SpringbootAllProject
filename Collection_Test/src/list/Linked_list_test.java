package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Linked_list_test {

	public static void main(String[] args) {
		
		Linked_list_test list=new Linked_list_test();
		list.linkedList();
	}
	
	
	public void linkedList()
	{
		List<String>employeelist=new LinkedList<>();
		employeelist.add("amit");
		employeelist.add("abhi");
		employeelist.add("poorav");
		employeelist.add("abhi");
		
		Iterator<String> iterator = employeelist.iterator();
		
		while(iterator.hasNext())
		{
			String next = iterator.next();
			
			System.out.println(next);
		
			
		}
		
	}
}
