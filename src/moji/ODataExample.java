package moji;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ODataExample {
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		ODataExample http = new ODataExample();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
		
		

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://services.odata.org/Northwind/Northwind.svc/Products/$count?$filter=Discontinued eq true";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "*/*");

		
		System.out.println("Response Code : " + con.getResponseCode());

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
	
	

}