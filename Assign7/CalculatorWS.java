package org.calculator;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public class CalculatorWS {
 @WebMethod
 public int add(int a, int b) {
 return a + b;
 }
 @WebMethod
 public int subtract(int a, int b) {
 return a - b;
 }
}
//CalculatorClientApp
package org.calculator.client;
import org.calculator.CalculatorWS;
import org.calculator.CalculatorWSService;
public class CalculatorClientApp {
 public static void main(String[] args) {
 CalculatorWSService service = new CalculatorWSService();
 CalculatorWS calculator = service.getCalculatorWSPort();
 int resultAdd = calculator.add(10, 5);
 int resultSub = calculator.subtract(10, 5);
 System.out.println("Addition Result: " + resultAdd);
 System.out.println("Subtraction Result: " + resultSub);
 }
}