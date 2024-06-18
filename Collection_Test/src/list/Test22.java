package list;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test22 {
	
	public static void main(String[] args) {
		
		
		String count="aaabbbccc";
		String[] split = count.split("");
		Map<String,Long> collect = Arrays.stream(split)
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect);
		
	}

}
