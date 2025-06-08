package com.sLsD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Root Class
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Person {

   private Long id;
   private String name;
   private String address;
   private Integer age;
   private String profession;
   
   public Person() {
	   System.out.println("No Arg Constructor::Person");
   }

}
