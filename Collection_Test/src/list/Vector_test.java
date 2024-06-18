package list;

import java.util.Vector;

public class Vector_test {
	
	public static void main(String[] args) {
		 
		Vector_test vector=new Vector_test();
		vector.addEmployee();
	}
	
	public void addEmployee()
	{
		

		Vector<String>empllist=new Vector<>();
		 
		 empllist.add("Amit");
		 empllist.add("Abhi");
		 empllist.add("hejal");
		 empllist.add("poorav");
		 empllist.add("manvik");
		 empllist.add("Amit");
		 empllist.add("Abhi");
		 empllist.add("hejal");
		 empllist.add("poorav");
		 empllist.add("manvik");
		 empllist.add("manvik");
		 empllist.addElement("ByAddElement");
		 
		 System.out.println("Size of Emp List::>"+empllist.size());
	System.out.println("Capicity of Emplist::>"+empllist.capacity());
	
	
	  for(String res:empllist)
	  {
		  System.out.println(res); 
		  
	  }	
		
	}
 
  
}
