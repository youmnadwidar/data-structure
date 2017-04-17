package eg.edu.alexu.csd.datastructure.calculator.cs74;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

public class MyCalculator implements ICalculator {
  /**
   * Adds given two numbers.
   *
   * @param x
   *          first number
   * @param y
   *          second number
   * @return the sum of the two numbers
   */
  public final int add(final int x,final  int y) {

    return x + y;
  }
  /**
   * Divids two numbers.
   * @param x
   *          first number
   * @param y
   *          second number
   * @return the division result
   */
  public float divide(int x, int y) {
    return (float) x / (float) y;
  }

}
