package com.asrracing.busca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Marcas {
	private	String url = "http://api.edmunds.com/api/vehicle/v2/fmt=json&api_key=";
	private String apikey = "f22n6wjee9fg6w82rg47yq72";

	public Marcas(){
		
	}
	
	public String getMarcas(){
		String RestCall = null;
		String res = "";
		String result = "";
		
		RestCall = url + apikey;
		try {
			//Conecta a API
			URL urlCall = new URL(RestCall);
			URLConnection cnx = urlCall.openConnection();
			
			//Almacena JSON
			BufferedReader in = new BufferedReader(new InputStreamReader(cnx.getInputStream()));
			while((res = in.readLine()) != null){
				result += res;
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.getMessage();
		}
		
		
		return result;
		
	}
}
