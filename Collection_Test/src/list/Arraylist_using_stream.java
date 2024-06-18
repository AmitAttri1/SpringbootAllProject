package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Arraylist_using_stream {
	public static void main(String[] args) {
		Arraylist_using_stream obj = new Arraylist_using_stream();
		obj.addEelment();

	}

	public void addEelment() {
		List<String> emloyeelist = new ArrayList<>();

		emloyeelist.add("amit");
		emloyeelist.add("abhi");
		emloyeelist.add("kavi");
		emloyeelist.add("krish");
		emloyeelist.add("ravi");
		emloyeelist.add("savi");
		/*
		 * for(String res:emloyeelist) { System.out.println(res); }
		 */

		Stream<String> streamEmployee = emloyeelist.stream();
		List<String> empList = streamEmployee.filter(s ->s.startsWith("k"))
		.map(String::toUpperCase)
		.collect(Collectors.toList());
		
		Iterator<String> iterator = empList.iterator();
		
		while(iterator.hasNext())
		{
			String next = iterator.next();
			System.out.println(next);
		}
		
		/*
		 * for(String res:empList) { System.out.println(res); }
		 */

	}

}
