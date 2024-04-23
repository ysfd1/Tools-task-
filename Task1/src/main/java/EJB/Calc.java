package EJB;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
@Stateless
public class Calc {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id ; 
	int Number1 ;
	int Number2 ;
	String Operation ;
	int result ; 
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Calc (){} 
	public Calc(int number1, int number2, String operation) {
		Number1 = number1;
		Number2 = number2;
		Operation = operation;
	}
	
	public int getNumber1() {
		return Number1;
	}
	
	public void setNumber1(int number1) {
		Number1 = number1;
	}
	
	

	public int getNumber2() {
		return Number2;
	}
	
	public void setNumber2(int number2) {
		Number2 = number2;
	}
	
	public String getOperation() {
		return Operation;
	}
	
	public void setOperation(String operation) {
		Operation = operation;
	}
	
	public int CalcResult (int num1 , int num2 , String operation)
	{
		int result = 0 ; 
		switch (operation) {
        case "+":
            result = num1 + num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("Error: Division by zero!");
            }
            break;
        default:
            System.out.println("Error: Invalid operation!");
            
	}
		return result;
	}
}
