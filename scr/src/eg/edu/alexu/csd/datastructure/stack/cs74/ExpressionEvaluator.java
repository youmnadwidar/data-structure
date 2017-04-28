package eg.edu.alexu.csd.datastructure.stack.cs74;

import java.util.Arrays;

import java.util.List;
import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * @author HP.
 * convert to postfix and evaluate it
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {

  /**
   * Takes a symbolic/numeric infix expression as input and converts it to.
   * postfix notation. There is no assumption on spaces between terms or the
   * length of the term (e.g., two digits symbolic or numeric term)
   * @param expression
   *          infix expression
   * @return postfix expression
   */
  public String infixToPostfix(final String expression) {
    Stack stack = new Stack();
    StringBuilder postfix = new StringBuilder();
    int flag = 0;
    String expressionM = expression.replaceAll("\\s", "");
    String[] operations = {"+", "/", "*", "-", "(", ")" };
    List<String> list = Arrays.asList(operations);
    int i = 0;
    while (i < expressionM.length()) {
      char temp = expressionM.charAt(i);
      if (list.contains(Character.toString(expressionM.charAt(i)))) {
        if (list.contains(Character.toString(expressionM.charAt(i + 1)))
            && (expressionM.charAt(i + 1) != '(' && temp != ')')
            && (temp != ')' && expressionM.charAt(i + 1) != '(')) {
          throw null;
        }

        if (stack.isEmpty() || temp == '(') {
          if (temp == '(') {

            flag++;
          }
          stack.push(temp);
          i++;

        } else if (temp == ')') {
          flag--;
          while (!stack.peek().equals('(')) {
            postfix.append(" " + stack.pop());
          }
          i++;

          stack.pop();
        } else if (temp == '-' || temp == '+') {

          while (!stack.isEmpty() && !stack.peek().equals('(')) {

            postfix.append(" " + stack.pop());

          }
          stack.push(expressionM.charAt(i));
          i++;

        } else if (temp == '*' || temp == '/') {
          if (!stack.isEmpty()
              && (stack.peek().equals('/') || stack.peek().equals('*'))) {

            postfix.append(" " + stack.pop());
          }
          stack.push(temp);
          i++;

        }

      } else {

        postfix.append(" " + temp);
        i++;
      }
    }
    if (flag != 0) {
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
   * @param expression
   *          postfix expression
   * @return the expression evaluated value
   */
  public int evaluate(final String expression) {
    float ans = 0;
    Stack stack = new Stack();
    String num = new String();
    if (expression.length() == 0 || expression == null) {
      throw new RuntimeException();
    }
    int i = 0;
    while (i < expression.length()) {
      if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
        while (expression.charAt(i) != ' ') {

          num += expression.charAt(i);
          i++;
        }

        stack.push((float) Integer.parseInt(num));
        i--;

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
      i++;
      num = "";
    }
    if (stack.size() > 1) {
      return 0;
    }
    ans = Math.round(ans);
    return (int) ans;
  }

}
