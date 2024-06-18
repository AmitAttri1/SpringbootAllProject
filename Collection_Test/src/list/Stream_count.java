package list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_count {
	
	public static void main(String[] args) {
		Stream_count abc=new Stream_count();
		abc.countCar();
		
		
	}
	
	private void countCar()
	{
		String count="aaabbbbccceekkmmmkmkm";
		
		String[] split = count.split("");
		
		 Map<String,Long> collect = Arrays.stream(split)
		 .filter(s->!s.isEmpty())
		 .map(String::toUpperCase)
		 .sorted(Comparator.reverseOrder())
		 //.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 //.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 System.out.println(collect);
		 //System.out.println(count);
		
		
		
	}

}
