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
    int flag = 0;
    StringBuilder num = new StringBuilder();
    String[] operations = { "+", "/", "*", "-", "(", ")" };
    List<String> list = Arrays.asList(operations);
    int i = 0;
    while (i < expression.length()) {
      if (list.contains(Character.toString(expression.charAt(i)))) {
        if (list.contains(Character.toString(expression.charAt(i + 1)))
            && (expression.charAt(i + 1) != '(' && expression.charAt(i) != ')')
            && (expression.charAt(i) != ')'
                && expression.charAt(i + 1) != '(')) {
          throw null;
        }

        if (stack.isEmpty() || expression.charAt(i) == '(') {
          if (expression.charAt(i) == '(') {

            flag++;
          }
          stack.push(expression.charAt(i));
          i++;

        } else if (expression.charAt(i) == ')') {
          flag--;
          while (!stack.peek().equals('(')) {
            postfix.append(" " + stack.pop());
          }
          i++;

          stack.pop();
        } else if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {

          while (!stack.isEmpty() && !stack.peek().equals('(')) {

            postfix.append(" " + stack.pop());

          }
          stack.push(expression.charAt(i));
          i++;

        } else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
          if (!stack.isEmpty()
              && (stack.peek().equals('/') || stack.peek().equals('*'))) {

            postfix.append(" " + stack.pop());
          }
          stack.push(expression.charAt(i));
          i++;

        }

      } else if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
        num = num.delete(0, num.length());
        while (i < expression.length() && expression.charAt(i) >= '0'
            && expression.charAt(i) <= '9') {

          num = num.append(expression.charAt(i));
          i++;
        }
        postfix.append(" " + num);
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
   * 
   * @param expression
   *          postfix expression
   * @return the expression evaluated value
   */
  public int evaluate(String expression) {
    float ans = 0;
    Stack stack = new Stack();
    String num = new String();
    if (expression.length() == 0 || expression == null) {
      throw new RuntimeException();
    }
    int i = 0;
    while (i < expression.length()) {
      if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
        while (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {

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
