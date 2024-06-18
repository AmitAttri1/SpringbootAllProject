package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	
	
	public static void main(String[] args) {
		StreamTest list=new StreamTest();
		list.startWith();
		

	}
	
	private void startWith()
	{
		List<String> empList = new ArrayList<>();
		empList.add("Amit");
		empList.add("Abhi");
		empList.add("ravi");
		empList.add("ramesh");
		empList.add("kamlesh");
		empList.add("kavi");

		Stream<String> stream = empList.stream();

		List<String> collect = stream.filter(s -> s.startsWith("a"))
				.map(String::toUpperCase)
				.collect(Collectors.toList());

		
		Iterator<String> iterator = collect.iterator();
		
		while(iterator.hasNext())
		{
			String next = iterator.next();
			
			System.out.println(next);
			
		}
		
	
		
	}

}
