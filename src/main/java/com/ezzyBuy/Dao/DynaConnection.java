package com.ezzyBuy.Dao;


import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.ezzyBuy.Domain.catlog;

public class DynaConnection {

	public static  String createConnection(){

		AWSCredentials Credentials = new BasicAWSCredentials(myConfig.getMyAccessId(), myConfig.getMySecretId());
		System.out.println("Credentials taken...");
		AmazonDynamoDBClient dynamoDB = new AmazonDynamoDBClient(Credentials);
		Region usWest2 = Region.getRegion(Regions.US_WEST_1);
		dynamoDB.setRegion(usWest2);
		System.out.println("dyan connected...");

		String tableName = "Mobiles";
		DescribeTableRequest describeTableRequest = new DescribeTableRequest().withTableName(tableName);
		TableDescription tableDescription = dynamoDB.describeTable(describeTableRequest).getTable();
		System.out.println("Table Description: " + tableDescription);
		
		String output ="successfully dyna connected";
		
		//catlog c1 = new catlog();
		//System.out.println("comapny name "+c1.getCompany());
		
		
	     
		
		
		return output;
	}
	
		public static Object addItem(String companyName, int price, int quantity, String productName){
		String companyname = companyName;
		int prce = price;
		int quant = quantity;
		String productname = productName;
		
		System.out.println("price is "+prce);
		
		AWSCredentials Credentials = new BasicAWSCredentials(myConfig.getMyAccessId(), myConfig.getMySecretId());
		System.out.println("Credentials taken...");
		AmazonDynamoDBClient dynamoDB = new AmazonDynamoDBClient(Credentials);
		Region usWest2 = Region.getRegion(Regions.US_WEST_1);
		dynamoDB.setRegion(usWest2);
		System.out.println("dyan connected...");
		
		String tableName = "Mobiles";
		
		Map<String, AttributeValue> item = newItem(companyname, prce, quant, productname);
        PutItemRequest putItemRequest = new PutItemRequest(tableName, item);
        PutItemResult putItemResult = dynamoDB.putItem(putItemRequest);
        System.out.println("Result: " + putItemResult);
		
		return null;
	}
	
	 private static Map<String, AttributeValue> newItem(String companyName, int price, int quantity, String productName) {
	        Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
	        item.put("companyName", new AttributeValue(companyName));
	        item.put("price", new AttributeValue().withN(Integer.toString(price)));
	        item.put("quantity", new AttributeValue().withN(Integer.toString(quantity)));
	        item.put("productName", new AttributeValue().withS(productName));
	        
	        System.out.println("object "+item.toString());
	        return item;
	    }

}
