package com.voting.main;

import java.util.Scanner;

public class trail {
public static void main(String[] args) {
	String [] arr= {"XYZ NAGAR","AYAN AGRAWAL"};
	Scanner kb= new Scanner(System.in);
	String name= kb.nextLine();
	for(String s: arr) {
		if(s.equals(name))
		System.out.println("true");
		else
			System.out.println("false");
	}
}
}
