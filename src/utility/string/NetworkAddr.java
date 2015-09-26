package utility.string;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkAddr {

	public static void FetchNetaddrFromCIDR(String cidr){
	    String[] parts = cidr.split("/");
	    String ip = parts[0];
	    int prefix;
	    if (parts.length < 2) {
	        prefix = 0;
	    } else {
	        prefix = Integer.parseInt(parts[1]);
	    }
	    int mask = 0xffffffff << (32 - prefix);
	    int value = mask;
	    byte[] bytes = new byte[]{ 
	            (byte)(value >>> 24), (byte)(value >> 16 & 0xff), (byte)(value >> 8 & 0xff), (byte)(value & 0xff) };
		byte[] inveseByte = new byte[]{
				(byte)(~bytes[0]), (byte)(~bytes[1]), (byte)(~bytes[2]), (byte)(~bytes[3])};

		try {
			InetAddress netAddr = InetAddress.getByAddress(bytes);
			System.out.println("Mask=" + netAddr.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("Address=" + ip);
	    System.out.println("Usable addresses NO="+(Math.pow(2, 32-prefix)-2));
	}
	
	public static void main(String argv[]){
		FetchNetaddrFromCIDR("192.168.10.0/24");
	}
	
}
