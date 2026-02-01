import java.util.Scanner;

public class Application_1 {
    
    public static double calculate(double num1, double num2, char operator) {
        double result = 0;
        
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed!");
                    return 0;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Error: Invalid operator! Please use +, -, *, or /");
                return 0;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            double number1 = scanner.nextDouble();
            
            System.out.print("Enter second number: ");
            double number2 = scanner.nextDouble();
            
            System.out.print("Enter operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            
            double result = calculate(number1, number2, operator);
            
            System.out.println("\n Result : ");
            System.out.println(number1 + " " + operator + " " + number2 + " = " + result);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter numbers correctly.");
        } finally {
            scanner.close();
        }
    }
}
