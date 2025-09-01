
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

  Calculator classUnderTest = new Calculator();

  @Test
  public void shouldAddTwoNumbers() {
    int arg1 = 5;
    int arg2 = 5;
    int expected = arg1 + arg2;

    int actualResult = classUnderTest.sum(arg1, arg2);
    assertEquals(expected, actualResult);
  }

  @Test
  public void shouldSumNegativeNumbers() {
    int arg1 = -5;
    int arg2 = -5;
    int expected = arg1 + arg2;

    int actualResult = classUnderTest.sum(arg1, arg2);
    assertEquals(expected, actualResult);
  }

  @Test
  public void shouldSummZeroNumbers() {
    int arg1 = 0;
    int arg2 = 0;

    int expected = arg1 + arg2;
    int actualResult = classUnderTest.sum(arg1, arg2);

    assertEquals(expected, actualResult);
  }

  @Test
  public void shouldSubtractTwoNumbers() {
    int arg1 = 5;
    int arg2 = 5;

    int expected = arg1 - arg2;
    int actualResult = classUnderTest.subtract(arg1, arg2);
    assertEquals(expected, actualResult);
  }

  @Test
  public void shouldSubtractZeroNumbers() {
    int arg1 = 0;
    int arg2 = 0;
    int expected = arg1 - arg2;
    int actualResult = classUnderTest.subtract(arg1, arg2);
    assertEquals(expected, actualResult);
  }

  @Test
  public void shouldSubstractNegativeNumbers() {
    int arg1 = -5;
    int arg2 = -5;

    int expected = arg1 - arg2;
    int actualResult = classUnderTest.subtract(arg1, arg2);
    assertEquals(expected, actualResult);
  }

  public void doSmth() {
    
  }



}