package eg.edu.alexu.csd.datastructure.stack.cs74;

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
  public String infixToPostfix(final String expression) {
    Stack stack = new Stack();
    StringBuilder postfix = new StringBuilder();
    if(expression.length()==0||expression==null||expression.charAt(0)<='0'
        ||expression.charAt(0)>='9'&&expression.charAt(0)!=' '){
      throw new RuntimeException();
    }
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == '*' || expression.charAt(i) == '/'
          || expression.charAt(i) == '-' || expression.charAt(i) == '+'
          || expression.charAt(i) == '(' || expression.charAt(i) == ')') {
        if (stack.isEmpty() || expression.charAt(i) == '(') {
          stack.push(expression.charAt(i));
        } else if (expression.charAt(i) == ')') {
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

      } else if (expression.charAt(i) != ' ') {
        postfix.append(" " + expression.charAt(i));
      }

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
    int ans = 0;
    Object temp = 0;
    Stack stack = new Stack();
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
        stack.push(Character.getNumericValue(expression.charAt(i)));
      } else if (expression.charAt(i) == '*' || expression.charAt(i) == '/'
          || expression.charAt(i) == '-' || expression.charAt(i) == '+') {
        temp = stack.pop();
        switch (expression.charAt(i)) {
        case '+':
          ans = (int )stack.pop() + (int)temp;
          break;

        case '-':
          ans = (int )stack.pop() - (int)temp;
          break;
        case '*':
          ans = (int )stack.pop() * (int)temp;

          break;
        case '/':
          ans = (int )stack.pop() / (int)temp;

          break;
        
        }
        stack.push(ans);
      }

    }
    return ans;
  }

}
