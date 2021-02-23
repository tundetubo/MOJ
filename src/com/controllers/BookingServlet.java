package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		Calendar booking = Calendar.getInstance();
		out.print("<p>Name of caller is </p> "+name+" <p>and time is <p>"+booking.getTime());
	
		/* create a calendar object for time before 9 am  */
		   Calendar bf9am = Calendar.getInstance();
		   
		   /* set time of bf9am calendar object to be 9 am */
		   bf9am.set(Calendar.HOUR_OF_DAY, 9);
		   System.out.println(" Hour of day is : " +bf9am.get(Calendar.HOUR_OF_DAY));
		   
		   
				   
		   /* check if bf9am is set */	   
		   boolean b = bf9am.isSet(Calendar.HOUR_OF_DAY); 
		   System.out.println(" ");
		   System.out.println(" Hour of day is set: " + b);
		   
		   /* create a calendar object for time of 6pm  */
		   Calendar bf6pm = Calendar.getInstance();
		   
		   /** set time of bf6pm calendar object to be 6pm */
		   bf6pm.set(Calendar.HOUR_OF_DAY, 18);
		   
		   /* create a calendar object for time of 8pm  */
		   Calendar bf8pm = Calendar.getInstance();
		   
		   /** set time of bf8pm calendar object to be 8pm */
		   bf8pm.set(Calendar.HOUR_OF_DAY, 20);
		   
		   System.out.println(" Hour of day is : " +bf8pm.get(Calendar.HOUR_OF_DAY));
		   
		   /* Create Monday from enum */
		   DayOfWeek monday = DayOfWeek.of(1); 
		   
		   /* create Tuesday */
		   monday = monday.plus(1);
		   
		   
		   /*create Wednesday */
		   monday = monday.plus(1);
		   
		  
		   /*create Thursday */
		   monday = monday.plus(1);
		   
		   
		   /*create Friday */
		   monday = monday.plus(1);
		   
		   
		   /*create Saturday */
		   monday = monday.plus(1);
		  
		   
		   /*create Sunday */
		   monday = monday.plus(1);
		  
		   
		   
		   /*create a callback calendar object with a minimum condition of 2 hours */
		   Calendar after2hours = Calendar.getInstance();
		   
		   /*add 2 hours to current time to meet minimum 2-hour-callback condition */
		   after2hours.add(Calendar.HOUR, 2);
		   
		   /* Check earliest call back time */
		   after2hours.getTime() ;
		    
		   
		   /* Display office hours on page*/
		   out.print("<p>Office hours are between: </p> "+bf9am.get(Calendar.HOUR_OF_DAY)+" am <p>and <p>"+bf8pm.get(Calendar.HOUR_OF_DAY)+"<span>pm</span>");
		   
		   Date time = booking.getTime();  
		  if((booking.before(bf9am))&& (booking.after(bf8pm))||(booking.before(DayOfWeek.of(7)))){
			 {	
				 
				 out.print("<p>Time is out of office hours!</p>");
				request.getRequestDispatcher("index.html").include(request, response);
			 }
			 
			}else{
				
				out.print("<p>we are open</p>");
				request.getRequestDispatcher("index.html").include(request, response);
			} 
	}

}
