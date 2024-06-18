package Core;

public class Missing_No {
	
	public static void main(String[] args) {
		
		int n=10;
		int sum=n*(n+1)/2;
		System.out.println("Sum of natural number::>"+sum);
		
		int [] intarray= {1,2,3,4,6,7,8,9,10};
		int k=0;
		
		for(int i=0; i<intarray.length; i++)
		{
			k=k+intarray[i];
			
		}
		
		System.out.println("Sum of array::>>"+k);
		
		int messingNumber =sum-k;
		System.out.println("messingNumber::>>"+messingNumber);
	}

}
