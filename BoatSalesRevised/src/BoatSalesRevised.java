/*This is a boat sales list, it calculates the cost of a listing of boats
	 *By Ethan O'Neill
	 *	12/12/2018 
	 */

    import java.text.*;
	import java.util.*;
	
public class BoatSalesRevised {
	//inputs data
	static String iString;
	static String iBoatType;
	static String iAccesType;
	static int iQty;
	static int AccessNum;

	static char inputAgain = 'Y';
	static Scanner myScanner;
	static NumberFormat nf;
	static double cBoatAmt;
	static double iPrepAmt;
	static double cAccessAmt;
	static double Per;
	
	//Ready for Calculations
	static double MarkUp;
	static double cSub;
	static double Tax;
	static double Total;
	//Read for Outputs
	static String oTotal;
	static String oTax;
	static String oSub;
	static String oMarkUp;
	static String oPrep;
	static String oBoatAmt;
	static int totalsales;
	static String fgrandtotal;
	static double grandtotal; 
	//static double totalsalesvalue;
public static void main(String[] args) {
	
		//call init
	init();
		//Self Note: Make sure to loop wiht 'Y'
	while (inputAgain=='Y') {
			//call input
	input();
			
			//call calculations
	calcs();
	
			
			//call output
	output();
	
	closing();
	
			//Prompt for next receipt
	System.out.print("Would you like to Enter another receipt? Y or N: ");
	inputAgain = myScanner.next().toUpperCase().charAt(0);
	}
	
		
	//System.out.println("Program Terminated, Have a good day, come back again!");
		
	}


private static void closing() {

	System.out.println("Program Terminated, Have a good day, come back again!");
}


public static void init() {
	
	//set scanner to the Console
	myScanner = new Scanner(System.in);
	
	//to allow spaces in strings
	myScanner.useDelimiter(System.getProperty("line.separator"));
	
	//set formatter to use U.S. currency format for $$
	nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
	}
public static void input() {
	
	//VALIDATION FOR BOAT COSTS
	do {
		
			
		
			System.out.println("--- Enter Boat cost: ");
			iString = myScanner.next();
			cBoatAmt = Double.parseDouble(iString);
			if (cBoatAmt <2500.00 || cBoatAmt > 150000.00) {
			//Boat Cost needs to be between $2,5000-150,000$
			
		
			System.out.println(" Price needs to between $2500.00 -$150,000.00, not any greater !1");
			}
		
		
		
}while (cBoatAmt <2500.00 || cBoatAmt > 150000.00);
	
	
	///VALIDATION FOR PREP COST
	
	do{ 
	
	
		
		System.out.println("Enter Prep cost: ");
		iString = myScanner.next();
		iPrepAmt = Double.parseDouble(iString);
		
		if (iPrepAmt < 100.00 || iPrepAmt > 9999.99) {
			
			System.out.println("Prep Cost Choice NOT VALID");
		}
		
	
	
	
	
	
	}while( iPrepAmt <100 || iPrepAmt > 9999.99) ;
	
	
	do {
	
		
	System.out.println("--- Enter Quanity '1 to 25' ");
	iString = myScanner.next();
	iQty = Integer.parseInt(iString);
	if (iQty < 1 || iQty > 25) {
		
		}
	
	

		
	
	
	}while(	iQty< 1 || iQty >25);

	
	
	
	
	
	
	
	
	
	
	
	
	boolean on = false;
	
	do  {
		System.out.println("--- Enter Boat type  'B' - 'P'-  'S' - 'C'  :  ");
		iString = myScanner.next().toUpperCase();
	switch(iString) {
	
	
	case "B":
		on = true;
		
		
		iBoatType = "Bass";
		Per = 0.33;
		
		break;
		
		
	case "P":
		on = true;
		iBoatType = "Pontoon";
		Per = 0.25;
		break;
	case "S":
		on = true;
		iBoatType  = "Ski";
		Per = 0.425;
		break;
	case "C":
		on = true;
		iBoatType  = "Canoe";
		Per = 0.20;
		break;

	}
	
	}while (on  == false);
	
	
	
	boolean T = false;
	do {
	try {
	System.out.println("--- Enter Boat Accesories Choices: ///  1 = electronics, 2  = ski package, 3 =  fishing package  :  ");
	iString = myScanner.next();
	AccessNum = Integer.parseInt(iString);
	} catch(NumberFormatException e) {
		System.out.println("Error. Please input a number between 1 and 3.");
	}
	//Case Structure and Validation for Accesories Type
	
	
		
	switch (AccessNum) {
	
	case 1:
		T = true;
		cAccessAmt = 5415.30	;
		iAccesType = "Electronics";
		
		break;
	case 2:
		T = true;
		cAccessAmt = 3980.00;
		iAccesType = "Ski Package";
		
		break;
	case 3:
		T = true;
		cAccessAmt = 345.45;
		iAccesType = "Fishing Package";
		
		break;
}
		
} while(T == false);
		
}	

public static void calcs() {
	
	
	
	//Calculations for Boat
	MarkUp = Per * cBoatAmt;
	cSub =   ( iPrepAmt+ cAccessAmt+ MarkUp + cBoatAmt )* iQty;
	Tax = cSub * 0.06;
	Total = cSub + Tax;
	//Rounding to .00
	
		
	
	MarkUp = Math.round(MarkUp);
		
	Tax = Math.round(Tax);
}
public static void output() {
	// just decimal placements to 2 places
	oTotal = nf.format(Total);
	oTax = nf.format(Tax);
	oSub = nf.format(cSub); 
	oMarkUp = nf.format(MarkUp);
	oPrep = nf.format(iPrepAmt); 
	oBoatAmt = nf.format(cBoatAmt);
	
	System.out.format("%-30s%5s%10s","INPUTS:"," " , "RESULTS" + "\n" + "\n" );
	System.out.format("%-30s%5s%10s","Boat Type is: " ," " , iBoatType + "\n");
	System.out.format("%-30s%5s%10s","Accesory is: " ," " , iAccesType+ "\n");
	System.out.format("%-30s%5s%10s","Quantity is: " ," " , iQty + "\n");
	System.out.format("%-30s%5s%10s","Boat Cost is: " ," " , oBoatAmt + "\n");
	System.out.format("%-30s%5s%10s","Accesory Cost is: " ," " , String.format(Locale.US , "%.2f", cAccessAmt)  + "\n");
	System.out.format("%-30s%5s%10s","Prep Cost is: " ," " ,  oPrep  + "\n");
	System.out.format("%-30s%5s%10s","Tax is: " ," " ,  oTax  + "\n");
	
	System.out.println("\n");
	//Accumalator for  the Amount of Sales 
	totalsales += 1;
	grandtotal = grandtotal + Total;
	fgrandtotal = nf.format(grandtotal);
	System.out.format("%-30s%5s%10s","Number of Sales is: ", " ",totalsales+ "\n" ) ;
	System.out.format("%-30s%5s%10s","Grand Total Sales: ", " ",  fgrandtotal + "\n");
}
}

