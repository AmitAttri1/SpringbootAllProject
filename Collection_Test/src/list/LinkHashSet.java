package list;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkHashSet {
	
	
public static void main(String[] args) {
		
	LinkHashSet list=new LinkHashSet();
	
		list.linkedList();
	}
	
	
	public void linkedList()
	{
		Set<String> setlist = new LinkedHashSet<>();
		setlist.add(null);
		setlist.add("amit");
		setlist.add("abhi");
		setlist.add("poorav");
		setlist.add("abhi");
		
		//Iterator<String> iterator = setlist.iterator();
		
		/*while(iterator.hasNext())
		{
			String next = iterator.next();
			
			System.out.println(next);
		
			
		}*/
		
		for(String list:setlist)
		{
			System.out.println(list);
		}
		
	}


}
