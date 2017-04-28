package eg.edu.alexu.csd.datastructure.stack.cs74;

import java.util.Arrays;

import java.util.List;
import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator {

  /**
   * Takes a symbolic/numeric infix expression as input and converts it to.
   * postfix notation. There is no assumption on spaces between terms or the
   * length of the term (e.g., two digits symbolic or numeric term)
   * 
   * @param expression
   *          infix expression
   * @return postfix expression
   */
  public String infixToPostfix(String expression) {
    Stack stack = new Stack();
    StringBuilder postfix = new StringBuilder();
    boolean flag = false;
    expression = expression.replaceAll("\\s", "");
    String[] operations = { "+", "/", "*", "-", "(", ")" };
    List<String> list = Arrays.asList(operations);

    for (int i = 0; i < expression.length(); i++) {

      if (list.contains(Character.toString(expression.charAt(i)))) {
        if (list.contains(Character.toString(expression.charAt(i + 1)))
            && expression.charAt(i + 1) != '('
            && expression.charAt(i + 1) != ')' && expression.charAt(i) != '(') {
          throw null;
        }

        if (stack.isEmpty() || expression.charAt(i) == '(') {
          if (expression.charAt(i) == '(') {
            flag = true;
          }
          stack.push(expression.charAt(i));
        } else if (expression.charAt(i) == ')') {
          flag = false;
          while (!stack.peek().equals('(')) {
            postfix.append(" " + stack.pop());
          }
          stack.pop();
        } else if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {

          while (!stack.isEmpty() && !stack.peek().equals('(')) {

            postfix.append(" " + stack.pop());

          }
          stack.push(expression.charAt(i));
        } else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
          if (!stack.isEmpty()
              && (stack.peek().equals('/') || stack.peek().equals('*'))) {

            postfix.append(" " + stack.pop());
          }
          stack.push(expression.charAt(i));

        }

      } else

      {

        postfix.append(" " + expression.charAt(i));
      }

    }
    if (flag) {
      throw new RuntimeException();
    }
    while (!(stack.isEmpty())) {
      postfix.append(" " + stack.pop());
    }
    postfix.deleteCharAt(0);
    return postfix.toString();
  }

  /**
   * Evaluate a postfix numeric expression, with a single space separator.
   * 
   * @param expression
   *          postfix expression
   * @return the expression evaluated value
   */
  public int evaluate(final String expression) {
    float ans = 0;
    Stack stack = new Stack();
    if (expression.length() == 0 || expression == null) {
      throw new RuntimeException();
    }
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {

        stack.push((float) Character.getNumericValue(expression.charAt(i)));
        // System.out.println(stack.peek());
      } else if (expression.charAt(i) == '*' || expression.charAt(i) == '/'
          || expression.charAt(i) == '-' || expression.charAt(i) == '+') {
        float temp = (float) stack.pop();
        switch (expression.charAt(i)) {
        case '+':
          ans = (float) stack.pop() + temp;
          break;

        case '-':
          ans = (float) stack.pop() - temp;
          break;
        case '*':
          ans = (float) stack.pop() * temp;

          break;
        case '/':
          ans = (float) stack.pop() / temp;

          break;
        default:
          break;

        }
        stack.push(ans);
      }

    }
    if (stack.size() > 1) {
      return 0;
    }
    ans = Math.round(ans);
    return (int) ans;
  }

}
