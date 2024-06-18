package com.test.utill;

import java.util.Comparator;
import java.util.Date;

public class Product2 implements Comparator<Product2> {
	
	private Integer pid;
	private String pname;
	private Date expDate;
	public Product2(Integer pid, String pname, Date expDate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.expDate = expDate;
	}
	
	public Product2() {
		// TODO Auto-generated constructor stub
	}

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
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Product2 [pid=" + pid + ", pname=" + pname + ", expDate=" + expDate + "]";
	}
	@Override
	public int compare(Product2 pd1, Product2 pd2) {
		
		if(pd1.getExpDate().compareTo(pd2.getExpDate())>0)
		{
			return 1;
			
		}
		else if(pd1.getExpDate().compareTo(pd2.getExpDate())<0)
		{
			return -1;
			
		}
		
		return 0;
	}

	
	

}
