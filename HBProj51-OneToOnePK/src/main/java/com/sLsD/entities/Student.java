/**
 * 
 */
package com.sLsD.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@AllArgsConstructor
public class Student implements Serializable {
	
	private Long sno;
	private String sname;
	private String course;
	private String saddr;
	private LibraryMembership libraryDetails;
	
	public Student() {
		System.out.println("No Arg Constructor:: Student");
	}
	
	@Override
	public String toString() {
		return String.format("Sno:: %d,Sname:: %s,Course:: %s,Address:: %s",sno,sname,course,saddr);
	}

}
