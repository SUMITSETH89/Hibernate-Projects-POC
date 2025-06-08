package com.sLsD.test;

public class SaveObjectOperationCase3 {
	//Case#3 Using Increment Generator in multi-threaded Environment  
	public static void main(String[]args){
		
		//Create Object
		TicketBookingOperation operation = new TicketBookingOperation();
		//Start Thread#1
		new Thread(operation).start();
		//Start Thread#2
		new Thread(operation).start();
		//Start Thread#3
		new Thread(operation).start();
		
		
	}

}
