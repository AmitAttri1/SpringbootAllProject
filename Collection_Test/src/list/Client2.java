package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client2 {
	
	public static void main(String[] args) {
		
	Employee2 emp1=new Employee2("Amit", 1000L, "Developer");
	Employee2 emp2=new Employee2("Abhi", 2000L, "Manager");
	Employee2 emp3=new Employee2("Kavi", 3000L, "Developer");
	Employee2 emp4=new Employee2("Ravi", 4000L, "Manager");
	
	Stream<Employee2> stream = Arrays.asList(emp1,emp2,emp3,emp4).stream();
	
	List<Employee2> collect = stream.filter(s->s.getSalary()>1000 && s.getDesignation().equals("Manager"))
		.filter(s->s.getName().startsWith("A"))
	.collect(Collectors.toList());
	
	for(Employee2 res:collect)
	{
		System.out.println(res.getName()+res.getSalary()+res.getDesignation());
	}
	}

}
