package LibrarySystem.util;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Utility class to help represent and validate SSNs.
 */
public class SSN {
    private static final Pattern regex = Pattern.compile("^(?!(000|666|9))\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$|^(?!(000|666|9))\\d{3}(?!00)\\d{2}(?!0000)\\d{4}$", Pattern.MULTILINE);
    private static final Pattern nextDigit = Pattern.compile("\\d", Pattern.MULTILINE);

    //We do not need to make SSN final since it is private and we know our class will never change it
    private final char[] SSN;

    /**
     * Creates a new SSN object.
     *
     * @param ssn A string of the format "XXX-XX-XXXX" or "XXXXXXXXX" containing a valid social security number
     *
     * @throws IllegalArgumentException If string passed in is not a valid SSN
     */
    public SSN(String ssn) throws IllegalArgumentException {
        if (regex.matcher(ssn).matches()) {
            SSN = new char[9];
            Scanner scanner = new Scanner(ssn);
            for (int i = 0; i < 9; i++) {
                SSN[i] = scanner.next(nextDigit).charAt(0);
            }
        }
        else {
            throw new IllegalArgumentException("Invalid SSN number!");
        }
    }

    /**
     * Gets the SSN as an array of chars (digits).
     * @return An array of digits representing the 9-digit SSN
     */
    public char[] GetSSN() {
        return SSN;
    }

    /**
     * Gets the last four digits of the SSN as a string.
     * @return A string containing the last 4 digits of the SSN
     */
    public String GetLastFour() {
        return new String(SSN, 4, 4);
    }

    /**
     * Converts the SSN digit array into a string.
     * @return A string representing the SSN
     */
    @Override
    public String toString() {
        return Arrays.toString(SSN);
    }
}
