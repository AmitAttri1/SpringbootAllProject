package list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
	
	public static void main(String[] args) {
		Test2 abc=new Test2();
		abc.listTesting();
		
	}

	
	public void listTesting()
	{
		Set<String>employee=new HashSet<>();
		employee.add("amit");
		employee.add("abhi");
		employee.add("ravi");
		employee.add("kavi");
		employee.add("ravi");
		employee.add("kavi");
		
		
		Stream<String> stream = employee.stream();
		
		List<String> collectlist = stream.filter(s->s.startsWith("r"))
		.map(String::toUpperCase )
		.collect(Collectors.toList());
		
		for(String cList:collectlist)
		{
			System.out.println(cList);
		}
		//System.out.println(collectlist);
		
		/*
		 * Iterator<String> iterator = employee.iterator();
		 * 
		 * 
		 * while(iterator.hasNext()) { String next = iterator.next();
		 * 
		 * System.out.println(next);
		 * 
		 * }
		 */
		
		/*
		 * for(String res:employee) { System.out.println(res); }
		 */
		//System.out.println(employee);
	}
}
