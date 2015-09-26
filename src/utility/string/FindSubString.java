package utility.string;

class FindSubString {
    /**
     * Returns a index to the first occurrence of target in source from a specific point,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, int pos, String target) {
        int index = -1;
        
        if(source.isEmpty() || pos >= source.length()){
        	return index;
        }
        
        String subSource = source.substring(pos);
        
        if(!target.isEmpty() && subSource.length() >= target.length())
        {
            for(int i=0; i< subSource.length()-target.length(); ++i)
            {  
                if( subSource.charAt(i) == target.charAt(0))
                {
                	int j=0;
                    for(;j < target.length(); j++)
                    {
                        if(subSource.charAt(i) != target.charAt(j))
                        {
                            break;
                        }
                        
                        i++;
                    }
                    
                    if(j >= target.length())
                    {
                    	index = i - j + pos;
                        break;
                    }
                    
                }
             }
        

        }
        
        return index;
        
    }
    
    
	public static void main(String[] args) {
		System.out.println("abc  is in hbjabchuj @"+strStr("hbjabchuj", 2, "abc"));//@3

	}
}