package com.ezzyBuy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.amazonaws.services.s3.model.Bucket;
import com.ezzyBuy.Dao.DbConnection;
import com.ezzyBuy.Domain.User;
import com.ezzyBuy.Domain.contactDetails;

@Path("/file")
public class RestfullService {
	
	
	@POST
	@Path("/signup")
	public Response userprofile(@FormParam("fname") String fname,
			@FormParam("lname") String lname,
			@FormParam("email") String email, 
			@FormParam("password") String password,
			@FormParam("cc") String cc,
			@Context HttpServletRequest req) {
			System.out.println("name is: "+fname);
			User user = new User();
			user.setFirstName(fname);
			user.setLastName(lname);
			user.setUserName(email);
			user.setPassword(password);
			user.setCreditCard(cc);
		//	AWSFacade fact= new AWSFacade();
			System.out.println("surname of the user is"+user.getLastName());
			String output = "Thankyou for registring with us you will recieve email shortly "+ user.getFirstName();
			DbConnection dbcon = new DbConnection();
			dbcon.insertUser(user);
			
			HttpSession session= req.getSession(true);
			session.setAttribute("username", email);
			session.setAttribute("sessionId", session.getId());
			session.setAttribute("usersfirstname", fname);
			session.setAttribute("userslastname", lname);
	
			System.out.println("User added");
		/*	
			Bucket bucket = fact.makeNewBucket(user);
			System.out.println("UploadFileService: After adding new bucket - "+user.getBucketname());
			dbcon.insertUser(user);
			
			String msgBody ="Your account was created on AirBox.";
			String msgHeader = "Registration Confirmation";
		*/
			/*
			ui = new ConcreteUserInfo(email);
			as = new AmazonSESSample();
			cm = new ConcreteMessage(msgBody, msgHeader);
			//ui.setReEmail(email);
			//cm.setMsgBody(msgBody);
			//cm.setMsgSubject(msgHeader);
			as.setConnec(ui, cm);
			*/
		return Response.status(200).entity(output).build();

	}
	
	@POST
	@Path("/contact")
	public Response contactUser(@FormParam("contactName") String contactName,
			@FormParam("contactPersonEmail") String contactPersonEmail,
			@FormParam("contactPersonMob") String contactPersonMob, 
			@FormParam("contactSubj") String contactSubj ){
		
			contactDetails cd = new contactDetails();
			cd.setContactName(contactName);
			cd.setContactPersonEmail(contactPersonEmail);
			cd.setContactPersonMob(contactPersonMob);
			cd.setContactSubj(contactSubj);
			
			System.out.println("contact persons email address is: "+cd.getContactPersonEmail());
			
			String output = "Thankyou for registring with us you will recieve email shortly "+ cd.getContactSubj();
			
			return Response.status(200).entity(output).build();
	}

	
	@GET
	@Path("/logout")
	public Response logout(@Context HttpServletRequest req) {
		HttpSession session= req.getSession(false);
		session.invalidate();
		System.out.println("User has logged out !");
		String output = "User has succesfully logged out";
		
		 return Response.status(200).entity(output).build();
		
	}
	
}
