package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class PolynomialSolver implements IPolynomialSolver {
  /**
   * .
   */
  final int num =1000;
  /**
   * .
   */
  DoublyLinkedList A = null;
  /**
   * .
   */
  DoublyLinkedList B = null;
  /**
   * .
   */
  DoublyLinkedList C = null;
  /**
   * .
   */
  DoublyLinkedList R = null;
/**
 * the name of the polynomial equation
 * @param poly
 * @return
 */
  public final boolean isSet(char poly) {
    poly = Character.toUpperCase(poly);
    switch (poly) {
    case 'A':
      return !(A == null);

    case 'B':
      return !(B == null);

    case 'C':
      return !(C == null);

    default:
      return false;
    }
  }

 /**
  * @param poly.
  * @param terms
  * 
  */
  public void setPolynomial(char poly, int[][] terms) {
    poly = Character.toUpperCase(poly);

    if (poly == 'A') {
      A = new DoublyLinkedList();
      A.clear();
      setPoly(A, terms);
    } else if (poly == 'B') {
      B = new DoublyLinkedList();
      B.clear();
      setPoly(B, terms);
    } else if (poly == 'C') {
      C = new DoublyLinkedList();
      C.clear();
      setPoly(C, terms);
    } else
      throw new RuntimeException();

  }

  /**
   * @param poly  .scr
   */
  public String print(char poly) {
    poly = Character.toUpperCase(poly);
    NodeDL newNode = null;

    if (poly == 'A' && A != null && !A.isEmpty()) {
      return printPoly(A, newNode);
    } else if (poly == 'B' && B != null && !B.isEmpty()) {
      return printPoly(B, newNode);
    } else if (poly == 'C' && C != null && !C.isEmpty()) {
      return printPoly(C, newNode);
    } else if (poly == 'R' && R != null && !R.isEmpty()) {
      return printPoly(R, newNode);
    }
    return null;
  }
/**
 * .
 * @param poly polynomial.
 */
  public void clearPolynomial(char poly) {
    poly = Character.toUpperCase(poly);

    if (poly == 'A' && A != null) {
      A.clear();
      A = null;
    } else if (poly == 'B' && B != null) {
      B.clear();
      B = null;
    } else if (poly == 'C' && C != null) {
      C.clear();
      C = null;
    }

  }

  /**
   * .
   * @param poly polynomial.
   * @param value the value of it.
   */
  public float evaluatePolynomial( char poly, final float value) {
    poly = Character.toUpperCase(poly);
    int answer = 0;
    NodeDL newNode;

    if (poly == 'A' && A != null && !A.isEmpty()) {

      newNode = A.getHead().getNext();
      while (newNode != A.getTail()) {
        Point point = new Point(0, 0);
        point = (Point) newNode.getData();
        answer += point.x * Math.pow(value, point.y);

        newNode = newNode.getNext();
      }
      return answer;
    } else if (poly == 'B' && B != null && !B.isEmpty()) {

      newNode = B.getHead().getNext();
      while (newNode != B.getTail()) {
        Point point = new Point(0, 0);
        point = (Point) newNode.getData();
        answer += point.x * Math.pow(value, point.y);

        newNode = newNode.getNext();
      }
      return answer;
     } else if (poly == 'C' && C != null && !C.isEmpty()) {

      newNode = C.getHead().getNext();
      while (newNode != C.getTail()) {
        Point point = new Point(0, 0);
        point = (Point) newNode.getData();
        answer += point.x * Math.pow(value, point.y);

        newNode = newNode.getNext();
      }
      return answer;
       } else {
      throw new RuntimeException();
    }
  }

/**
 * .
 * @param poly1  polynomial1.
 * @param poly2 polynomial2
 * @return the add
 */
  public int[][] add(char poly1, char poly2) {
    poly1 = Character.toUpperCase(poly1);
    poly2 = Character.toUpperCase(poly2);
    R = new DoublyLinkedList();
    R.clear();
    if (!isSet(poly1) || !isSet(poly2)) {
      throw new RuntimeException();
    }
    if (poly1 == 'A') {
      switch (poly2) {
      case 'A':
        addLinked(A, A, R);
        break;

      case 'B':
        addLinked(A, B, R);
        break;

      case 'C':
        addLinked(A, C, R);
        break;

      default:
        throw new RuntimeException();

      }
    } else if (poly1 == 'B') {
      switch (poly2) {
      case 'A':
        addLinked(B, A, R);
        break;

      case 'B':
        addLinked(B, B, R);
        break;

      case 'C':
        addLinked(B, C, R);
        break;

      default:
        throw new RuntimeException();

      }
    } else if (poly1 == 'C') {
      switch (poly2) {
      case 'A':
        addLinked(C, A, R);
        break;

      case 'B':
        addLinked(C, B, R);
        break;

      case 'C':
        addLinked(C, C, R);
        break;

      default:
        throw new RuntimeException();

      }
    } else {
      throw new RuntimeException();
    }
    NodeDL current = R.getHead().getNext();
    int[][] resultArray = new int[R.getSize()][2];
    for (int i = 0; i < resultArray.length; i++) {
      Point point = new Point(0, 0);
      point = (Point) current.getData();
      resultArray[i][0] = point.x;
      resultArray[i][1] = point.y;
      current = current.getNext();
    }
    return resultArray;
  }

  /**
   * .
   * @param poly1 polynomial1.
   * @param poly2 polynomial2
   * @return subtract
   */
  public int[][] subtract(char poly1, char poly2) {
    poly1 = Character.toUpperCase(poly1);
    poly2 = Character.toUpperCase(poly2);
    R = new DoublyLinkedList();
    R.clear();
    if (!isSet(poly1) || !isSet(poly2)) {
      throw new RuntimeException();
    }
    if (poly1 == poly2) {
      int[][] ans = {{0, 0}};
      return ans;
    }
    if (poly1 == 'A') {
      switch (poly2) {

      case 'B':
        subtractLinked(A, B);
        break;

      case 'C':
        subtractLinked(A, C);
        break;

      default:
        throw new RuntimeException();

      }
    } else if (poly1 == 'B') {
      switch (poly2) {
      case 'A':
        subtractLinked(B, A);
        break;
      case 'C':
        subtractLinked(B, C);
        break;

      default:
        throw new RuntimeException();

      }
    } else if (poly1 == 'C') {
      switch (poly2) {
      case 'A':
        subtractLinked(C, A);
        break;

      case 'B':
        subtractLinked(C, B);
        break;

      default:
        throw new RuntimeException();

      }

    } else {
      throw new RuntimeException();
    }
    NodeDL current = R.getHead().getNext();
    int[][] resaultArray = new int[R.getSize()][2];
    for (int i = 0; i < resaultArray.length; i++) {
      Point point = new Point();
      point = (Point) current.getData();
      resaultArray[i][0] = point.x;
      resaultArray[i][1] = point.y;
      current = current.getNext();

      }
    return resaultArray;
     }

  /**
   * @param poly1 polynomial1.
   * @param poly2 polynomial2.
   * @return multiply.
   */
  public int[][] multiply(char poly1, char poly2) {
    poly1 = Character.toUpperCase(poly1);
    poly2 = Character.toUpperCase(poly2);
    R = new DoublyLinkedList();
    R.clear();
    if (!isSet(poly1) || !isSet(poly2)) {
      throw new RuntimeException();
    }
    if (poly1 == 'A') {
      switch (poly2) {
      case 'A':
        multiplyLists(A, A);
        break;

      case 'B':
        multiplyLists(A, B);
        break;

      case 'C':
        multiplyLists(A, C);
        break;

      default:
        throw new RuntimeException();

      }
    } else if (poly1 == 'B') {
      switch (poly2) {
      case 'A':
        multiplyLists(B, A);
        break;

      case 'B':
        multiplyLists(B, B);
        break;

      case 'C':
        multiplyLists(B, C);
        break;

      default:
        throw new RuntimeException();

      }
    } else if (poly1 == 'C') {
      switch (poly2) {
      case 'A':
        multiplyLists(C, A);
        break;

      case 'B':
        multiplyLists(C, B);
        break;

      case 'C':
        multiplyLists(C, C);
        break;

      default:
        throw new RuntimeException();

      }

    } else {
      throw new RuntimeException();
    }
    NodeDL current = R.getHead().getNext();
    int[][] resaultArray = new int[R.getSize()][2];
    for (int i = 0; i < resaultArray.length; i++) {
      Point point = new Point();
      point = (Point) current.getData();
      resaultArray[i][0] = point.x;
      resaultArray[i][1] = point.y;
      current = current.getNext();

    }
    return resaultArray;

  }
  /**
   * add .
   * @param list1 the first operand.
   * @param list2 the second operand.
   * @param result the result of the added.
 */
  public void addLinked(final DoublyLinkedList list1,
      final DoublyLinkedList list2, final DoublyLinkedList result) {
    if (list1 == null || list2 == null) {
      throw new RuntimeException();
    }
    result.clear();
    NodeDL temp1 = list1.getHead().getNext(), temp2 = list2.getHead().getNext();

    while (temp1 != list1.getTail() && temp2 != list2.getTail()) {
      Point point1 = new Point(0, 0);
      Point point2 = new Point(0, 0);
      Point point3 = new Point(0, 0);
      point1 = (Point) temp1.getData();
      point2 = (Point) temp2.getData();
      if (point1.y == point2.y) {
        point3.x += point1.x + point2.x;
        point3.y = point1.y;
        temp1 = temp1.getNext();
        temp2 = temp2.getNext();

      } else if (point1.y > point2.y) {
        point3.x = point1.x;
        point3.y = point1.y;
        temp1 = temp1.getNext();
      } else {
        point3.x = point2.x;
        point3.y = point2.y;
        temp2 = temp2.getNext();
      }
      if (point3.x != 0) {
        result.add(point3);
      }
    }
    while (temp1 != list1.getTail()) {
      result.add(temp1.getData());
      temp1 = temp1.getNext();

    }
    while (temp2 != list2.getTail()) {
      result.add(temp2.getData());
      temp2 = temp2.getNext();
    }
  }
/**
 *.
 * @param list1 first operand.
 * @param list2 second operand.
 *
 */
  public final void subtractLinked(final DoublyLinkedList list1,
      final DoublyLinkedList list2) {
    if (list1.getSize() == 0 || list2.getSize() == 0
        || list1 == null || list2 == null) {
      throw new RuntimeException();
    }
    R.clear();
    NodeDL temp1;
    NodeDL temp2;
    temp1 = list1.getHead().getNext();
    temp2 = list2.getHead().getNext();

    while (temp1 != list1.getTail() && temp2 != list2.getTail()) {
      Point point1 = new Point(0, 0);
      Point point2 = new Point(0, 0);
      point1 = (Point) temp1.getData();
      point2 = (Point) temp2.getData();
      Point point3 = new Point(0, 0);

      if (point1.y == point2.y) {
        point3.x += point1.x - point2.x;
        point3.y = point1.y;
        temp1 = temp1.getNext();
        temp2 = temp2.getNext();

      } else if (point1.y > point2.y) {
        point3.x += point1.x;
        point3.y = point1.y;
        temp1 = temp1.getNext();

      } else if (point1.y < point2.y) {
        if (point2.x == 1) {
          point3.x += -1;
        } else if (point2.x == -1) {
          point3.x += 1;
        } else {
          point3.x += -point2.x;
        }
        point3.y = point2.y;
        temp2 = temp2.getNext();
      }
      if (point3.x != 0) {
        R.add(point3);
      }
    }

    while (temp1 != list1.getTail()) {
      R.add(temp1.getData());
      temp1 = temp1.getNext();
    }
    while (temp2 != list2.getTail()) {
      Point point = new Point(0, 0);
      point = (Point) temp2.getData();
      point.x = -point.x;
      R.add(temp2.getData());
      temp2 = temp2.getNext();
    }

  }
/**
 * .
 * @param list the set polynomial.
 * @param terms the array of terms .
 */
  public void setPoly(final DoublyLinkedList list, final int[][] terms) {
    int max = num;
    for (int i = 0; i < terms.length; i++) {
      if (terms[i][1] < 0) {
        throw null;
      }
      Point point = new Point(0, 0);
      point.x = terms[i][0];
      point.y = terms[i][1];
      if (point.y < max) {
        list.add(point);
        max = point.y;
      } else {
        throw new RuntimeException();
      }
    }
  }
/**
 *.
 * @param list the polynomial.
 * @param node linked node.
 * @return string polynomial
 */
  public String printPoly(final DoublyLinkedList list, NodeDL node) {
    String polyy = "";
    node = list.getHead().getNext();
    while (node != list.getTail()) {
      Point point = new Point(0, 0);
      point = (Point) node.getData();
      if (node.getPrev() != list.getHead() && point.x > 0) {
        polyy += "+";
      }

      if (point.x != 0) {
        polyy += "" + point.x;
        if (point.y == 1) {
          polyy += "x";
        } else if (point.y > 1) {
          polyy += "x^" + point.y;
        }

      }
      node = node.getNext();
    }
    return polyy;
  }
/**
 * the two linked lists.
 * @param list1 first operand
 * @param list2 second operand
 */
  public void multiplyLists(final DoublyLinkedList list1,
      final DoublyLinkedList list2) {
    R.clear();
    NodeDL temp1 = list1.getHead().getNext(), temp2 = list2.getHead().getNext();
    DoublyLinkedList templist1 = new DoublyLinkedList();
    DoublyLinkedList templist2 = new DoublyLinkedList();
    DoublyLinkedList templist3 = new DoublyLinkedList();

    while (temp1 != list1.getTail()) {
      Point point1 = new Point(0, 0);
      point1 = (Point) temp1.getData();
      templist1.clear();
      templist3.clear();
      temp2 = list2.getHead().getNext();
      while (temp2 != list2.getTail()) {

        Point point2 = new Point(0, 0);
        Point point3 = new Point(0, 0);
        point2 = (Point) temp2.getData();
        point3.x = point1.x * point2.x;
        point3.y = point1.y + point2.y;
        templist1.add(point3);
        temp2 = temp2.getNext();
      }
      if (templist2.getHead().getNext() == templist2.getTail()) {
        templist3.getHead().setNext(templist1.getHead().getNext());
        templist1.getHead().getNext().setPrev(templist3.getHead());
        templist3.getTail().setPrev(templist1.getTail().getPrev());
        templist1.getTail().getPrev().setNext(templist3.getTail());
      } else {
        addLinked(templist1, templist2, templist3);
      }

      templist2.getHead().setNext(templist3.getHead().getNext());
      templist3.getHead().getNext().setPrev(templist2.getHead());
      templist2.getTail().setPrev(templist3.getTail().getPrev());
      templist3.getTail().getPrev().setNext(templist2.getTail());
      temp1 = temp1.getNext();
    }
    R.getHead().setNext(templist2.getHead().getNext());
    templist2.getHead().getNext().setPrev(R.getHead());
    templist2.getTail().getPrev().setNext(R.getTail());
    R.getTail().setPrev(templist2.getTail().getPrev());
    NodeDL getSizeNode = R.getHead().getNext();
    while (getSizeNode != R.getTail()) {
      R.setSize(R.getSize() + 1);
      getSizeNode = getSizeNode.getNext();
    }
  }

}
