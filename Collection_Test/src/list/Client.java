package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
	
	public static void main(String[] args) {
		
		Employee emp1=new Employee("Amit", 1000L, "Manager");
		Employee emp2=new Employee("Abhi", 2000L, "Devloper");
		Employee emp3=new Employee("Ravi", 3000L, "Manager");
		Employee emp4=new Employee("Kavi", 4000L, "Devloper");
		Employee emp5=new Employee("Ramesh",5000L, "Manager");
		
		Stream<Employee> stream = Arrays.asList(emp1,emp2,emp3,emp4,emp5).stream();
		List<Employee> collect = stream.filter(s->s.getDesignation().equals("Manager") && s.getSalary()>2000)
		.collect(Collectors.toList());
		
		for(Employee res:collect)
		{
			System.out.println(res.getName()+res.getSalary()+res.getDesignation());
			
		}
		
	}

}
