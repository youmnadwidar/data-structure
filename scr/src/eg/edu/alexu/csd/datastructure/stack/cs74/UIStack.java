package eg.edu.alexu.csd.datastructure.stack.cs74;

import java.util.Scanner;

/**
 * @author HP.
 * stack operations
 *
 */
class UIStack {

  /**
   * @param args main class
   */
  public static void main(final String[] args) {
    Stack stack = new Stack();
    boolean end = false;
    while (!end) {

      System.out.println("1: Push\n" + "2: Pop\n" + "3: Peek\n"
          + "4: Get size\n" + "5: Check if empty\n" + "6: Print The Stack\n"
          + "7:End The program\n" + "Enter the operation you want ");
      Scanner scan = new Scanner(System.in);
      char operation = scan.next().charAt(0);
      switch (operation) {
      case '1':
        System.out.println("Enter the value");
        Object value = scan.next();
        stack.push(value);
        break;
      case '2':
        if (stack.isEmpty()) {
          System.out.println("The Stack is empty");
        } else {
          stack.pop();
        }
        break;
      case '3':
        if (stack.isEmpty()) {
          System.out.println("The Stack is empty");
        } else {
          System.out.println(stack.peek());

        }
        break;
      case '4':
        System.out.println(stack.size());
        break;
      case '5':
        if (stack.isEmpty()) {
          System.out.println("The stack is Empty");
        } else {
          System.out.println("The stack is not Empty");
        }
        break;
      case '6':
        Stack temp = new Stack();
        for (int i = 0; i < stack.size(); i++) {
          temp.push(stack.pop());
        }
        for (int i = 0; i < stack.size(); i++) {
          System.out.println(temp.peek());
          stack.push(temp.pop());
        }
        break;
      case '7':
        end = true;
        break;

      default:
        System.out.println("Enter a Valid operation");
        break;
      }
      scan.close();
    }
  }

}
