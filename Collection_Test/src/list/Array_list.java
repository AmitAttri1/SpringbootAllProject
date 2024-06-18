package list;

import java.util.ArrayList;
import java.util.List;

public class Array_list {
	
	public static void main(String[] args) {
		Array_list obj=new Array_list();
		obj.addEelment();
		
	}
	
	public void addEelment()
	{
		List<String>emloyeelist=new ArrayList<>();
		
		emloyeelist.add("amit");
		emloyeelist.add("abhi");
		
		for(String res:emloyeelist)
		{
			System.out.println(res);
		}
		}
}