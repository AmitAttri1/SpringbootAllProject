package list;

import java.util.HashSet;
import java.util.Set;

public class Hashset_testing {
	
public static void main(String[] args) {
		
	Hashset_testing list=new Hashset_testing();
		list.linkedList();
	}
	
	
	public void linkedList()
	{
		Set<String>setlist=new HashSet<>();
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
