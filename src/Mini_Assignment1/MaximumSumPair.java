package Mini_Assignment1;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MaximumSumPair {

    private static final Logger logger = Logger.getLogger(MaximumSumPair.class);

    /**
     * Finds the maximum pair sum in an array.
     * @param arr The input array of integers.
     * @return The maximum sum of a pair in the array, or -1 if there are fewer than 2 elements in the array.
     */
    public static int findMaxPairSum(int[] arr) {

        int maxSum = arr[0] + arr[1];
        int firstNumber = arr[0];
        int secondNumber = arr[1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentSum = arr[i] + arr[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    firstNumber = arr[i];
                    secondNumber = arr[j];
                }
            }
        }

        logger.info("Pair with maximum sum are: (" + firstNumber + ", " + secondNumber + ")");
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter the size of the array: ");
        int size;
        try {
            size = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Invalid input. Size must be an integer.");
        }

        if (size < 2) {
            throw new IllegalArgumentException("Array must contain at least 2 elements.");
        }

        int[] arr = new int[size];
        logger.info("Enter the elements of the array: ");
        for (int index = 0; index < size; index++) {
            try {
                arr[index] = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Invalid input. Elements must be integers.");
            }
        }

        int maxPairSum = findMaxPairSum(arr);
        logger.info("Maximum pair sum: " + maxPairSum);
    }
}
