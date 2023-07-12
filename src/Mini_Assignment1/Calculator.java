package Mini_Assignment1;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static Logger logger = Logger.getLogger(Calculator.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            logger.info("Enter the operation (+, -, *, /): ");
            String operation = scanner.nextLine();

            logger.info("Enter the number of operands (up to 4): ");
            int numOperands = scanner.nextInt();

            if (numOperands <= 0 || numOperands > 4) {
                throw new IllegalArgumentException("Invalid number of operands.");
            }

            double[] operands = new double[numOperands];
            for (int i = 0; i < numOperands; i++) {
                logger.info("Enter operand " + (i + 1) + ": ");
                operands[i] = scanner.nextDouble();
            }

            double result = 0;
            switch (operation) {
                case "+":
                    result = performAddition(operands);
                    break;
                case "-":
                    result = performSubtraction(operands);
                    break;
                case "*":
                    result = performMultiplication(operands);
                    break;
                case "/":
                    result = performDivision(operands);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation.");
            }

            logger.info("Result: " + result);
        } catch (InputMismatchException e) {
            logger.info("Invalid input. Please enter numeric values.");
        } catch (IllegalArgumentException e) {
            logger.info(e.getMessage());
        } catch (ArithmeticException e) {
            logger.info(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Performs addition of multiple numbers.
     *
     * @param numbers The numbers to be added.
     * @return The result of the addition operation.
     */
    public static double performAddition(double... numbers) {
        double result = 0;
        for (double number : numbers) {
            result += number;
        }
        return result;
    }

    /**
     * Performs subtraction of multiple numbers.
     *
     * @param numbers The numbers to be subtracted.
     * @return The result of the subtraction operation.
     */
    public static double performSubtraction(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    /**
     * Performs multiplication of multiple numbers.
     *
     * @param numbers The numbers to be multiplied.
     * @return The result of the multiplication operation.
     */
    public static double performMultiplication(double... numbers) {
        double result = 1;
        for (double number : numbers) {
            result *= number;
        }
        return result;
    }

    /**
     * Performs division of multiple numbers.
     *
     * @param numbers The numbers to be divided.
     * @return The result of the division operation.
     * @throws ArithmeticException If division by zero is encountered.
     */
    public static double performDivision(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            result /= numbers[i];
        }
        return result;
    }
}


