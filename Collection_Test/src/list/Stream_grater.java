package list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Stream_grater {
	public static void main(String[] args) {
		
		Stream_grater stream_grater=new Stream_grater();
		stream_grater.graterNumber();
		
	}
	public void graterNumber()
	{
		int [] intarray= {1,2,3,4,5,6,7,8,9,10,15,13,14};
		
	IntStream stream = Arrays.stream(intarray);
	
	/*
	 * IntStream abc=stream.filter(n->n>5);
	 * 
	 * abc.forEach(System.out::println);
	 */
			
			Collections.reverse(Arrays.asList(stream) );
			System.out.println(stream);
	
		
	}
	

}
