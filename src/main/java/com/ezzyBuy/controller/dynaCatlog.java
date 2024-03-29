package com.ezzyBuy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ezzyBuy.Dao.DbConnection;
import com.ezzyBuy.Dao.DynaConnection;
import com.ezzyBuy.Domain.catlog;
import com.google.gson.Gson;


@Path("/catlog")
public class dynaCatlog {

	
	@POST
	@Path("/addCatlog")
	@Produces(MediaType.APPLICATION_JSON)
	public String addCatlog(@FormParam("companyname") String companyname, 
			@FormParam("productname") String productname,
			@FormParam("price") int price,
			@FormParam("quantity") int quantity
			) {
	
		System.out.println("this is the value of  "+productname+" $ "+price +" and company is "+companyname);
		
		catlog c = new catlog();
		c.setCompany(companyname);
		c.setPrice(price);
		c.setProduct(productname);
		c.setQuantity(quantity);
		
		System.out.println("name of company from catlog object "+c.getCompany());
		//DynaConnection.createConnection();
		//DynaConnection.addItem(c.getCompany(), c.getPrice(), c.getQuantity(), c.getProduct());
		
		//Gson gson = new Gson();
		//String catlogJson= gson.toJson(c);
		//System.out.println("string of json is "+catlogJson);
		
		
		//List<String> allitems=new ArrayList<String>();
		//allitems = DynaConnection.getAllItems();
		
	//	System.out.println("allitems in controller are "+allitems);
		DbConnection.details(c.getCompany(), c.getPrice(), c.getQuantity(), c.getProduct());
		System.out.println("db added");
		
		List<catlog> allitems=new ArrayList<catlog>();
		allitems = DbConnection.getDetails();

		Gson gson = new Gson();
		String catlogJson= gson.toJson(allitems);
		System.out.println("string of json is "+catlogJson);
		
		
		
		
		
		
		return catlogJson;
		
	}
	
	
	@GET
	@Path("/productCatlog")
	public String productCatlog() {
		List<catlog> allitems=new ArrayList<catlog>();
		allitems = DbConnection.getDetails();

		Gson gson = new Gson();
		String catlogJson= gson.toJson(allitems);
		System.out.println("string of json is "+catlogJson);
		

		
		return catlogJson;
	}
	
}
