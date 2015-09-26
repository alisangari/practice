package utility.string;

public class DotSplitStrCmp {

	public static Integer versionCompare(String str1, String str2)
	{
	    String[] vals1 = str1.split("\\.");
	    String[] vals2 = str2.split("\\.");
	    int i = 0;
	    // set index to first non-equal ordinal or length of shortest version string
	    while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])) 
	    {
	      i++;
	    }
	    // compare first non-equal ordinal number
	    if (i < vals1.length && i < vals2.length) 
	    {
	        int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
	        return Integer.signum(diff);
	    }
	    // the strings are equal or one string is a substring of the other
	    // e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
	    else
	    {
	        return Integer.signum(vals1.length - vals2.length);
	    }
	}
	
	public static void main(String argv[]){
		//String version1 = "1.2.3";
		String version1 = "192.168.0.10";
		//String version2 = "1.2.3.1";
		String version2 = "192.168.1.1";
		char sign = ' ';
		switch(versionCompare(version1, version2)){
		case 1:
			sign = '>';
			break;
		case -1:
			sign = '<';
			break;
		case 0:
			sign = '=';
			break;
		}
		System.out.println(version1+sign+version2);
	}
}
