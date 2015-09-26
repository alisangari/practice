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
		
		try {
			InetAddress netAddr = InetAddress.getByAddress(bytes);
			System.out.println("Mask=" + netAddr.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		byte[] inveseBytes = new byte[]{
				(byte)(~bytes[0]), (byte)(~bytes[1]), (byte)(~bytes[2]), (byte)(~bytes[3])};
	    
		String[] ips = ip.split("\\.");
				
		int[] ipsInt = {Integer.parseInt(ips[0]), Integer.parseInt(ips[1]),Integer.parseInt(ips[2]),Integer.parseInt(ips[3])};
		
		int[] NetWork = {bytes[0] &ipsInt[0], bytes[1] &ipsInt[1],bytes[2] &ipsInt[2],bytes[3] &ipsInt[3] };
		int[] Broadcast = {inveseBytes[0] | ipsInt[0], inveseBytes[1] | ipsInt[1],inveseBytes[2] | ipsInt[2], (inveseBytes[3] | ipsInt[3]) &0xff};
		
		
	    System.out.println("Address=" + ip);
	    System.out.println("Usable addresses NO="+(int)(Math.pow(2, 32-prefix)-2));
	    System.out.println("Network="+NetWork[0]+"."+NetWork[1]+"."+NetWork[2]+"."+NetWork[3]);
	    System.out.println("Broadcast="+Broadcast[0]+"."+Broadcast[1]+"."+Broadcast[2]+"."+Broadcast[3]);
	}
	
	public static void main(String argv[]){
		FetchNetaddrFromCIDR("192.168.10.10/30");
	}
	
}
