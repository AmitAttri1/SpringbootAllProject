package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Productdetail{
	 int id;
	 String Name;
	float prize;
	
	public String toString() {
        return "Productdetail{" +
                "id=" + id +
                ", name='" + Name + '\'' +
                ", prize=" + prize +
                '}';
    }
	

	public Productdetail(int id, String Name , float prize)
	{
		this.id=id;
		this.Name=Name;
		this.prize=prize;
		
	
	
}
}
public class Arraylist_Stream {
	
	public static void main(String[] args) {
		
		List<Productdetail> productList=new ArrayList<>();
		productList.add(new Productdetail (1,"Hp computer",20000f));
		productList.add(new Productdetail (2,"Dell computer",25000f));
		productList.add(new Productdetail (3,"lenovo computer",30000f));

		 List<Productdetail> collect = productList.stream()
		.filter(p->p.prize>20000)
		.collect(Collectors.toList());
		  
		 System.out.println(collect.toString());
		 
		 
		
	}
	

}



