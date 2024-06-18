package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream_count {
	
	public static void main(String[] args) {
		
		String countStream="aaaabbbcccddeefff";
		
		String[] split = countStream.split("");
		
		Map<String,Long> collect = Arrays.stream(split)
		
		.filter(s->!s.isEmpty())
		.map(String :: toUpperCase)
		.sorted(Comparator.reverseOrder())
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(collect);
		
	}

}
