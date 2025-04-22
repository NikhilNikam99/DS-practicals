package org.calculator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path("/calculator")
public class CalculatorRest {
 @GET
 @Path("/add")
 @Produces(MediaType.TEXT_PLAIN)
 public String add(@QueryParam("a") int a, @QueryParam("b") int b) {
 return "Addition Result: " + (a + b);
 }
 @GET
 @Path("/subtract")
 @Produces(MediaType.TEXT_PLAIN)
 public String subtract(@QueryParam("a") int a, @QueryParam("b") int b) {
 return "Subtraction Result: " + (a - b);
 }
}