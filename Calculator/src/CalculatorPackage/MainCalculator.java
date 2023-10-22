/**
 * CALCULATOR by Davide Reverberi (matr. 332781)
 * 
 * Development of a simple calculator that can perform addition, subtraction, products, division, 
 * and modulus of 2 integers or 2 doubles.
 * 
 * This program allows the user to exit from the calculator by digiting "esc" and is able to
 * handle exceptions due to incorrect input or algebraic errors.
 * 
 * NOTES:
 * -Once the operation and the type of operation have been selected, the 2 numbers must be entered to
 * return to the starting menu. 
 * -If an invalid value is entered when a number is requested, the second number must also be entered
 *  before returning to the menu.
 * -Division by zero between double numbers is supported (result = infinity).
 *
 */

package CalculatorPackage;

import java.util.Scanner;

/**
 * Class for calculator operation.
 * @author Davide Reverberi
 */
public class MainCalculator {

	public MainCalculator()
	{
	}
	
	/**
	 * Function to have a double number as input.
	 * 
	 * @param s Scanner object to use the console as input.
	 * @return The double number entered from the console by the user or an invalid type error.
	 */
	public static double getDoubleNumber(Scanner s) 
	{
		System.out.println("\nInsert number: \n");
		if(s.hasNextDouble())
		{
			return s.nextDouble();
		}else
		{
			System.out.println("\nInvalid type!\n");
			s.nextLine();
			return 1;
		}
	}
	
	/**
	 * Function to have an integer number as input.
	 * 
	 * @param s Scanner object to use the console as input.
	 * @return The int number entered from the console by the user or an invlid type error.
	 */
	public static int getIntNumber(Scanner s)
	{
		System.out.println("\nInsert number: \n");
		if(s.hasNextInt())
		{
			return s.nextInt();
		}else
		{
			System.out.println("\nInvalid type!\n");
			s.nextLine();
			return 1;
		}
	}

	public static void main(String[] args)
	{
		
		Scanner s = null;
		
		try {
			s = new Scanner(System.in);
			
			while(true)
			{
				System.out.println("+++++++++++ CALCULATOR +++++++++++\nSupported Operation:\n+ to addition\n- to subtraction\n"
						+ "* to multiplication\n/ to division\n% to module \n\"esc\" to exit from the calculator\n");
				System.out.println("\nInsert the operation:\n");
				
				String input = null;
				input = s.nextLine();
				
				if(input.equals("+") || input.equals("-") || input.equals("/") || input.equals("*") || input.equals("%"))     
				{
					System.out.println("\nint or double operation? (i = int, d = double, r = reset)\n");
					
					String operation_type = null;
					operation_type = s.nextLine();		 //Getting the operation type (only integer or double are allowed)	
					
					if(operation_type.equals("i")) 		 //Managing operations if user entered "int" type
					{
						try
						{
							int first_number = 0;
							int second_number = 0;
							int result = 0;
							
							first_number = getIntNumber(s);  	//Getting the first number
							second_number = getIntNumber(s);	//Getting the second number
							
							switch (input) {
								case "+": result = first_number + second_number; break;
								case "-": result = first_number - second_number; break;
								case "*": result = first_number * second_number; break;
								case "/": result = first_number/second_number; break;
								case "%": result = first_number%second_number; break;
								default:
								{
									System.out.println("\nUnknown operation or invalid syntax\nRetry..\n");
									result = 0;
								}
							}
							System.out.println("\nResult (int): " + result + "\n\n");
							
						}
						catch (ArithmeticException af)  	//Management of division by zero (exception in int numbers)
						{
							System.out.println("\nException: Can't divide by zero!\n");
						}	
						
					}else if(operation_type.equals("d")) 	//Managing operations if user entered "double" type
						{
							double first_number = 0;
							double second_number = 0;
							double resultDouble = 0;
							
							first_number = getDoubleNumber(s);		//Getting the first number
							second_number = getDoubleNumber(s);		//Getting the second number
					
							switch (input) {
								case "+": resultDouble = first_number + second_number; break;
								case "-": resultDouble = first_number - second_number; break;
								case "*": resultDouble = first_number * second_number; break;
								case "/": resultDouble = first_number/second_number; break;
								case "%": resultDouble = first_number%second_number; break;
								default:
								{
									System.out.println("\nInvalid syntax\nRetry..\n");
									resultDouble = 0;
								}
							}
							System.out.println("\nResult: (double) " + resultDouble + "\n\n");
							
						  }else if(operation_type.equals("r"))  	//r to reset and return to the starting menu
						  	{
							  continue;
						  	}else
						  	{
						  		System.out.println("\nInvalid type error. int or double are the only types allowed\n\n");
						  		continue;
						  	}
					
						s.nextLine();		
				}else {
					if(input.equals("esc"))  //esc to fast quit the calculator
					{
						System.out.println("\nClosing...\n");
						return;
					}else
					{
						System.out.println("\nUnknow operation, retry..\n");
					}
				}
			}
		}
		catch (NumberFormatException nf) {
			System.out.println("Exception: NumberFormatException!");
		}
		finally
		{
			if(s != null) 
			{
				s.close();
				return;
			}
			
		}

	}

}
