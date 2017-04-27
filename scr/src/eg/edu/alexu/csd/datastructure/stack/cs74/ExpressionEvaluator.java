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
    if (expression.length() == 0 || expression == null) {
      throw new RuntimeException();
    }
  
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == '*' || expression.charAt(i) == '/'
          || expression.charAt(i) == '-' || expression.charAt(i) == '+'
          || expression.charAt(i) == '(' || expression.charAt(i) == ')') {
        boolean flag = true;
        if (stack.isEmpty() || expression.charAt(i) == '(') {
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

      } else if (expression.charAt(i) != ' ') {
        postfix.append(" " + expression.charAt(i));
      }

    }
    if(flag){
      throw null;
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
    if (expression.length() == 0 || expression == null) {
      throw new RuntimeException();
    }
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
        if(expression.charAt(i+1) >= '0' && expression.charAt(i+1) <= '9'){
          throw new RuntimeException();
        }
        stack.push((float)Character.getNumericValue(expression.charAt(i)));
       // System.out.println(stack.peek());
      } else if (expression.charAt(i) == '*' || expression.charAt(i) == '/'
          || expression.charAt(i) == '-' || expression.charAt(i) == '+') {
       float temp = (float)stack.pop();
        switch (expression.charAt(i)) {
        case '+':
          ans = (float) stack.pop() + temp;
          break;

        case '-':
          ans = (float) stack.pop() -  temp;
          break;
        case '*':
          ans = (float)stack.pop() * temp;

          break;
        case '/':
          ans = (float)stack.pop() / temp;

          break;

        }
        stack.push(ans);
      }

    }
    if(stack.size()!=1){
      throw null;
    }
    ans = Math.round(ans);
    return (int) ans;
  }

}
