package com.restassured.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomUtils {
	
	private RandomUtils() {
		
	}
	
	private static final SecureRandom random= new SecureRandom();
	
	public static String generateRandomString(int length) {

		String text ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String text1 ="abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(length);
		for( int i = 0; i < length; i++ ) 
			sb.append( text.charAt( random.nextInt(text.length()) ) );
		    sb.append( text1.charAt( random.nextInt(text.length()) ) );
		return sb.toString();

	}
	public static String generateRandomStringinsmall(int length) 
	{
		String text1 ="abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(length);
		for( int i = 0; i < length; i++ ) 
		    sb.append( text1.charAt( random.nextInt(text1.length()) ) );
		return sb.toString();

	}

	public static String generateRandomNumericString(int length) {
		String textnumber ="0123456789";
		StringBuilder sb = new StringBuilder(length);
		for( int i = 0; i < length; i++ ) 
			sb.append( textnumber.charAt( random.nextInt(textnumber.length()) ) );
		return sb.toString();

	}
	
	public static String generateRandomSpecialCharacterString(int length) {
		String specialcharacter ="!@#$%&";
		StringBuilder sb = new StringBuilder(length);
		for( int i = 0; i < length; i++ ) 
			sb.append( specialcharacter.charAt( random.nextInt(specialcharacter.length()) ) );
		return sb.toString();

	}

	
	public static String generateRandomHBnumber() {
		
		return generateRandomString(5)+generateRandomNumericString(2)+generateRandomSpecialCharacterString(2);
	}

	   public static int generateRandomPositiveInteger() {
		      Random rd = new Random(); // creating Random object
		      return rd.nextInt(100);
		   
	   }
	
}
