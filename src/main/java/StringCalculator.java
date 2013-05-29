/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 5/29/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public int result = 0;
    public int Add (String inputString) {
        String regex = "([\n;,./]*)";
        if (inputString.isEmpty()) {
            return result;
        }
        String[] spilitString = inputString.split(regex);
        for (String sNumber : spilitString) {
            if (!sNumber.isEmpty()) {
                int number = Integer.parseInt(sNumber);
                if (number < 0 ) {
                    throw new NumberFormatException ("Negatives not allowed");
                }

                result += number;
            }

        }
        return result;
    }
}
