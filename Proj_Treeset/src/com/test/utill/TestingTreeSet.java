package com.test.utill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;

public class TestingTreeSet {
	
	public Set<Product2> getProductDetails2() throws ParseException
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Set<Product2> treeSet = new TreeSet<>(new Product2());
		treeSet.add(new Product2(1, "leptop",sdf.parse("20251210")));
		treeSet.add(new Product2(3, "leptop",sdf.parse("20231011") ));
		treeSet.add(new Product2(2, "leptop", sdf.parse("20100810")));
		
		return  treeSet;
		
	}

}
