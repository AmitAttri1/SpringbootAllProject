package com.test.utill;

public class Product  implements Comparable<Product>{
	
	private Integer pid;
	private String pname;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Product(Integer pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + "]";
	}
	@Override
	public int compareTo(Product product) {
		
		
		return this.pname.compareTo(product.pname);
	}
	
	/*
	 * //get data by name
	 * 
	 * @Override public int compareTo(Product product) {
	 * 
	 * return this.pname.compareTo(product.getPname()); }
	 */
	
	
	
	
	/*public int compareTo(Product product) {
		
		
		
		 * if(this.pid>product.getPid()) { return 1;
		 * 
		 * } else if(this.pid<product.getPid()) { return -1;
		 * 
		 * }
		 * 
		 * return 0;
		 
		 
		
		  
		
		
		 * if(this.pid>0) { return 1; } else if(this.pid<0) { return -1; }
		 * 
		 * return 0;
		 
		
		
		 * if(this.pid>product.getPid()) { return 1; } else
		 * if(this.pid<product.getPid()) { return -1; }
		 * 
		 * return 0;
		 
	}
	*/
	
	

}
