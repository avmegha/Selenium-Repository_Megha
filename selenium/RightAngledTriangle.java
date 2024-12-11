package week1.assignments;

import java.util.Scanner;

public class RightAngledTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Correct class and variable name

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt(); // Read the number of rows from user input

        // Outer loop for rows
        for (int i = 1; i <= rows; i++) {
            // Inner loop for printing stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to the next line after each row
        }

        scanner.close(); // Close the Scanner to free resources
    }
}
