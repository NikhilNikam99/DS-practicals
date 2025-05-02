//CalculatorRestClientApp
package org.calculator.client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class CalculatorRestClientApp {
 public static void main(String[] args) {
 try {
 String url = "http://desktop4ss78ci:8080/CalculatorWSApplication/webresources/calculator/add?a=10&b=5";
 String url =
"http://localhost:8080/CalculatorWSApplication/webresources/calculator/add?a=10&b=5";
 URL obj = new URL(url);
 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 con.setRequestMethod("GET");
 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
 String inputLine;
 StringBuilder response = new StringBuilder();
 while ((inputLine = in.readLine()) != null) {
 response.append(inputLine);
 }
 in.close();

 System.out.println("Response: " + response.toString());
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
}