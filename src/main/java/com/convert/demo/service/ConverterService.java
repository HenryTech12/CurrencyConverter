package com.convert.demo.service;
import java.util.*;
import java.io.*;
import java.net.*;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Service; 

@Service
public class ConverterService {

    public void convertAmount(String from, String to, String amount , ModelAndView mv) throws Exception {
      StringBuilder response = getJSON();
		
		JSONObject info = new JSONObject(response.toString());
		
		JSONObject dataResponse = info.getJSONObject("data");
	   JSONObject currencyInfo = dataResponse.getJSONObject(to);
        
		String value = currencyInfo.get("value").toString();
      
       if(!amount.equals("")) {
           double getAmount = Double.parseDouble(amount);
           double result = getAmount * Double.parseDouble(value);
           mv.addObject("result",amount+" "+from+ " = "+ to +" "+result);
        }
       else {
            mv.addObject("result","amount can't be empty");
        }
	 }

    
   private StringBuilder getJSON() throws Exception {
      String apiKey = "https://api.currencyapi.com/v3/latest?apikey=cur_live_CqXZRexhp5kSz6F4NUDWzeIxX34G4aacBJsdOoxg";
		URL url = new URL(apiKey);
		HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
		urlc.setRequestMethod("GET");
		
		InputStreamReader isr = new InputStreamReader(urlc.getInputStream());
		BufferedReader read = new BufferedReader(isr);
		
		String line = "";
		StringBuilder response = new StringBuilder();
		while((line = read.readLine()) != null) {
			 response.append(line);
	   }
        return response;
   }

  public void addCountryInfo(ModelAndView mv) throws Exception {
       StringBuilder response = getJSON();
       JSONObject info = new JSONObject(response.toString());
       JSONObject dataResponse = info.getJSONObject("data");
       List<String> list = new ArrayList<>();
       for(String key : dataResponse.keySet()) {
            list.add(key);
      } 
      mv.addObject("list",list);
   }
}