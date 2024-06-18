package list;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Teting12 {

	public static void main(String[] args) {
		Teting12 teting12=new Teting12();
		
		teting12.arrayIntList();
	}
	
	private void arrayIntList()
	{
		int [] intarray= {1,3,4,6,7,8,9,10};
		
		IntStream stream = Arrays.stream(intarray);
		
		IntStream abc=stream.filter(n->n>5);
				
		abc.forEach(System.out::println);
			
		
	}
}
