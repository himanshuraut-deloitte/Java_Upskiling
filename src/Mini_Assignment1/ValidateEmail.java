package Mini_Assignment1;

import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateEmail {
    static Logger logger = Logger.getLogger(ValidateEmail.class);

    /**
     * Checks if a given string is a valid email address.
     * @param email The email address to be validated.
     * @return true if the email address is valid, false otherwise.
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(email).matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter an email address: ");
        String email = scanner.nextLine();

        boolean isValid = isValidEmail(email);

        if (isValid) {
            logger.info("The "+email+" is a valid email address");
        } else {
            logger.info("The "+email+" is a invalid email address");
        }

        scanner.close();
    }
}

