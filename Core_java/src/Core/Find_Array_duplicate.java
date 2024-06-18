package Core;

public class Find_Array_duplicate {
	
	public static void main(String[] args) {
		
		int [] intarray= {1,2,3,4,5,6,3,4,6};
		
		for(int i=0; i<intarray.length; i++)
		{
			
		for(int k=i+1; k<intarray.length; k++){
			
			if(intarray[i]==intarray[k])
			{
				System.out.println("Duplicate array are "+intarray[k]);
			}
			
		}
		}
		
	}

}
