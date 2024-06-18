package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arraylist_using_itrator {
	
	public static void main(String[] args) { 
		
		Arraylist_using_itrator obj=new Arraylist_using_itrator();
		obj.itrator();
		
	}
	
	
	
	
	public void itrator()
	{
		List<String>employeelist=new ArrayList<>();
		employeelist.add("amit");
		employeelist.add("abhi");
		employeelist.add("poorav");
		
		Iterator<String> iteratorlist = employeelist.iterator();
		
		
		while(iteratorlist.hasNext())
		{
			String next = iteratorlist.next();
			System.out.println(next);
			
		}
		
		
		
	}

}
