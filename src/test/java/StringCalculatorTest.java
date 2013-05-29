import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 5/29/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculatorTest {

    @Test
    public void testInputZero() {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(0,sc.Add(""));
    }

    @Test
    public void testSimpleAdd() {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(3,sc.Add("1,2"));
    }

    @Test
    public void testMoreInputNumber() {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(6,sc.Add("1,2,3"));
    }

    @Test
    public void testWithEndLineDelimiter() {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(6,sc.Add("1,2\n3"));
    }

    @Test
    public void testWithEndLineDelimiterAtTheEnd() {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(6,sc.Add("1,2,3,\n"));
    }

    @Test
    public void testWithDifferentDelimiter() {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(6,sc.Add("1//2;3,"));
    }

    @Rule
    public ExpectedException myException = ExpectedException.none();

    @Test (expected = NumberFormatException.class)
    public void testException() {
        StringCalculator sc= new StringCalculator();
        sc.Add("-1,-2");
        myException.expect(NumberFormatException.class);
        myException.expectMessage("Negative is not allowed");
    }


}
