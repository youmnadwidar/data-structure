package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import java.util.Scanner;

public class Test {

	private static Scanner scan;

	public static void main(String[] args) {
		
		PolynomialSolver test =new PolynomialSolver();
		char poly1;
		char poly2;

		String menu = "Please choose an action \n" + "-----------------------\n"
				+ "1- Set a polynomial variable \n"
				+"2- Print the value of a polynomial variable\n"
				+"3- Add two polynomials\n"
				+"4- Subtract two polynomials\n"
				+"5- Multiply two polynomials\n"
				+"6- Evaluate a polynomial at some point\n"
				+"7- Clear a polynomial variable\n"
				+"====================================================================\n";
System.out.println(menu);
scan = new Scanner(System.in);
int operation =scan.nextInt();
switch (operation) {
case 1:System.out.println("Insert the variable name : A, B or C");
poly1=scan.next().charAt(0);
	System.out.println("Insert the polynomial terms in the form :\n"+
" (coeff1 , exponent1 ), (coeff2 , exponent2 ), ..");
	String points =scan.next();
	int i =points.charAt(1)-'0';
	System.out.println(i);
	int [][] terms =new int [12][2];
	test.setPolynomial(poly1, terms);
	System.out.println("Polynomial "+poly1+"is set");
	break;
case 2:
	System.out.println("Insert the variable name : A, B, C or R\n");
	poly1=scan.next().charAt(0);
	
	System.out.println("Value in "+poly1+": "+test.print(poly1));

	break;
case 3:
	poly1=scan.next().charAt(0);

 while (test.isSet(poly1)){
	 System.out.println("Variable not set");
		poly1=scan.next().charAt(0);

 }
 
 poly2=scan.next().charAt(0);

 while (test.isSet(poly2)){
	 System.out.println("Variable not set");
		poly1=scan.next().charAt(0);

 }
	
	
	break;
/*case value:
	
	break;
case value:
	
	break;
case value:
	
	break;
default:
	break;*/
}
	}
}
