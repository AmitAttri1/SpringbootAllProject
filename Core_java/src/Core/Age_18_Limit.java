package Core;

import java.util.Scanner;

public class Age_18_Limit {
	
	public static void main(String[] args) {
		
		//int [] intArray={12,13,15,16,19,20,18};
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please enter a value to validate yourself");
		int n=scanner.nextInt();
		
			if(n>=18)
			{
				System.out.println("permit::>>"+n);
			}
			else {
				System.out.println("not permit::>>"+n);
			}
		
	}

}
