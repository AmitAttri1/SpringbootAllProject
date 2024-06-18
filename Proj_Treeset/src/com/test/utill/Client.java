package com.test.utill;

import java.text.ParseException;
import java.util.Set;

public class Client {
	
	public static void main(String[] args) throws ParseException {
		
		TestingTreeSet testingTreeSet =new TestingTreeSet();
		
		Set<Product2> productDetails = testingTreeSet.getProductDetails2();
		
		for(Product2 product:productDetails)
		{
			System.out.println(product);
		}
		
		
	}

}
