package utility.string;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

public class CharToHex {
	
	public static String hexToChar(String hexString){
		
		//convert hex-encoded string back to original string
		byte[] decodedHex = DatatypeConverter.parseHexBinary(hexString);
		String decodedString="";
		try {
			decodedString = new String(decodedHex, "UTF-8");
			 System.out.printf(hexString+" decoded : %s\n", decodedString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
			
		return decodedString;
	}
	
	public static String charToHex(String string){
		 byte[] stringBytes = string.getBytes();
		 String hexString = DatatypeConverter.printHexBinary(stringBytes);
		 System.out.printf(string+" hex: 0x%s\n", hexString);
		 
		 return hexString;
	}
	   
	public static void main(String argv[]){
		
		String hex = charToHex("🍚");
		hexToChar(hex);

	}
}
