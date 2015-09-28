package ali;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Sample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String[] strs = {"é", "ŷ", "ಠ","🍚"};//"é", "ŷ", "ಠ",
		for (String str : strs) {
			System.out.println(str);
			char[] ch = str.toCharArray();
			if(ch.length > 1){
				System.out.println("-->"+ch.length);
				String s1 = Character.toString(ch[0]);
				String s2 = Character.toString(ch[1]);
				byte[] b1 = s1.getBytes("UTF-8");
				byte[] b2 = s2.getBytes("UTF-8");
				//char[] ch = st.toCharArray();
				//System.out.println(ch[0]);
				System.out.println(convert(b1));
				System.out.println(convert(b2));
				System.out.println();
			}else{
				byte[] b = str.getBytes("UTF-8");
				//char[] ch = st.toCharArray();
				//System.out.println(ch[0]);
				System.out.println(convert(b));
			}
		}
	}

	public static String convert(byte[] bytes){
		long num = new BigInteger(bytes).intValue();
        System.out.println(new BigInteger(bytes).intValue());
        return Long.toHexString(num);
	}
}