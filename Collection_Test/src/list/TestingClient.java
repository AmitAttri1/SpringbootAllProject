package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestingClient {
	
	public static void main(String[] args) {
		
		TestingClient testingClient = new TestingClient();
		Integer[] numberDetails = testingClient.numberDetails();
		
		
		
	
		
		
		/*
		TestingClient testingClient = new TestingClient();
		List<String> countriesList = testingClient.getCountries();
		
		Stream<String> streamCountries = countriesList.stream();
		List<String> collectList = streamCountries.filter(s->s.startsWith("I"))
		.map(String::toUpperCase)
		.collect(Collectors.toList());
		
		for(String countName:collectList) {
			System.out.println(countName);
		}
		*/
		
		
	}
	
	
	private List<String> getCountries(){
		List<String> nameContryList = new ArrayList<>();
		nameContryList.add("India");
		nameContryList.add("Japan");
		nameContryList.add("Banglades");
		return nameContryList;
	}
	

	private Integer[] numberDetails(){	
		Integer[] intArray = new  Integer[5];
		intArray[0]=1;
		intArray[1]=2;
		intArray[2]=3;
		intArray[3]=4;
		intArray[4]=5;	
		return intArray;
	}
	
	
	

}
