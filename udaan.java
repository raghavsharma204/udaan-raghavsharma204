/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udaan;

/**
 *
 * @author dell pc
 */

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;



public class Udaan {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception 
    {
     try{   
        String sUrl="https://newsapi.org/v2/top-headlines?apiKey=cd1db87dec794c2288c915ba6abeee94&country=in";
         
   
        
       URL url = new URL(sUrl);
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.connect();
         
        // getting firstName and lastName
        
        JsonParser jp = new JsonParser(); //from gson
    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
    
        
        
        String Status;
            Status = (String) jp.get("status");
        String totalResults;
         totalResults = (String) jp.get("totalResults");
         
        System.out.println(Status);
        System.out.println(totalResults);
               
        
        Map articles = ((Map)jp.get("articles"));
         
        
        Iterator<Map.Entry> itr1 = articles.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
         
        
        JSONArray ja;
            ja = (JSONArray) jp.get("articles");
        
        Iterator itr2 = ja.iterator();
         
        while (itr2.hasNext()) 
        {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    }
        
        catch(Exception e){
        }}
        // TODO code application logic here

    }
  
     
