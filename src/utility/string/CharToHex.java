package utility.string;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

public class CharToHex {
	
	public static String charTOHex(char a){
		
		String string = a+"";
		int no = Integer.parseInt(string);
		String hex = Integer.toHexString(no);
		System.out.println("Hex value is " + hex);
			
		return hex;
	}
	
	public static void charToHex(String s){
		 //print hex string version of HELLO WORLD
		 byte[] helloBytes = s.getBytes();
		 String helloHex = DatatypeConverter.printHexBinary(helloBytes);
		 System.out.printf("Hello hex: 0x%s\n", helloHex);
		 
		 //convert hex-encoded string back to original string
		 byte[] decodedHex = DatatypeConverter.parseHexBinary(helloHex);
		 String decodedString;
		try {
			decodedString = new String(decodedHex, "UTF-8");
			 System.out.printf("Hello decoded : %s\n", decodedString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
	   
	public static void main(String argv[]){
		//System.out.println("ø hex="+charTOHex('ø'));
		charToHex("ø");

	}
}
