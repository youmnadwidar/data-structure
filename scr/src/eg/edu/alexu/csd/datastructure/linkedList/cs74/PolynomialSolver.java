package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class PolynomialSolver implements IPolynomialSolver {
  DoublyLinkedList A = null;
  DoublyLinkedList B = null;
  DoublyLinkedList C = null;
  DoublyLinkedList R = null;

  public boolean isSet(char poly) {
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

  @Override
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

  @Override
  public String print(char poly) {
    poly = Character.toUpperCase(poly);
    NodeDL newNode = null;

    if (poly == 'A' && A != null && !A.isEmpty())
      return printPoly(A, newNode);

    else if (poly == 'B' && B != null && !B.isEmpty())
      return printPoly(B, newNode);

    else if (poly == 'C' && C != null && !C.isEmpty())
      return printPoly(C, newNode);
    else if (poly == 'R' && R != null && !R.isEmpty())
      return printPoly(R, newNode);
    return null;
  }

  @Override
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
    } else
      throw new RuntimeException();

  }

  @Override
  public float evaluatePolynomial(char poly, float value) {
    poly = Character.toUpperCase(poly);
    int answer = 0;
    NodeDL newNode;

    if (poly == 'A' && A != null && !A.isEmpty()) {

      newNode = A.head.getNext();
      while (newNode != A.tail) {
        Point point = new Point(0, 0);
        point = (Point) newNode.getData();
        answer += point.x * Math.pow(value, point.y);

        newNode = newNode.getNext();
      }
      return answer;
    } else if (poly == 'B' && B != null && !B.isEmpty()) {

      newNode = B.head.getNext();
      while (newNode != B.tail) {
        Point point = new Point(0, 0);
        point = (Point) newNode.getData();
        answer += point.x * Math.pow(value, point.y);

        newNode = newNode.getNext();
      }
      return answer;
    }

    else if (poly == 'C' && C != null && !C.isEmpty()) {

      newNode = C.head.getNext();
      while (newNode != C.tail) {
        Point point = new Point(0, 0);
        point = (Point) newNode.getData();
        answer += point.x * Math.pow(value, point.y);

        newNode = newNode.getNext();
      }
      return answer;
    }

    else
      throw new RuntimeException();
  }

  @Override
  public int[][] add(char poly1, char poly2) {
    poly1 = Character.toUpperCase(poly1);
    poly2 = Character.toUpperCase(poly2);
    R = new DoublyLinkedList();
    R.clear();
    if (!isSet(poly1) || !isSet(poly2))
      throw new RuntimeException();
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
    } else
      throw new RuntimeException();
    NodeDL current = R.head.getNext();
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

  @Override
  public int[][] subtract(char poly1, char poly2) {
    poly1 = Character.toUpperCase(poly1);
    poly2 = Character.toUpperCase(poly2);
    R = new DoublyLinkedList();
    R.clear();
    if (!isSet(poly1) || !isSet(poly2))
      throw new RuntimeException();
    if (poly1 == poly2) {
      int[][] ans = { { 0, 0 } };
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

    } else
      throw new RuntimeException();
    NodeDL current = R.head.getNext();
    int[][] resaultArray = new int[R.getSize()][2];
    for (int i = 0; i < resaultArray.length; i++) {
      Point point = new Point();
      point = (Point) current.getData();
      resaultArray[i][0] = point.x;
      resaultArray[i][1] = point.y;
      current = current.getNext();

    }
    if (resaultArray[0][1] == -1)
      resaultArray[0][1] = 1;
    return resaultArray;
  }

  @Override
  public int[][] multiply(char poly1, char poly2) {
    poly1 = Character.toUpperCase(poly1);
    poly2 = Character.toUpperCase(poly2);
    R = new DoublyLinkedList();
    R.clear();
    if (!isSet(poly1) || !isSet(poly2))
      throw new RuntimeException();
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

    } else
      throw new RuntimeException();
    NodeDL current = R.head.getNext();
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

  public void addLinked(DoublyLinkedList list1, DoublyLinkedList list2, DoublyLinkedList result) {
    if (list1 == null || list2 == null)
      throw new RuntimeException();
    result.clear();
    NodeDL temp1 = list1.head.getNext(), temp2 = list2.head.getNext();

    while (temp1 != list1.tail && temp2 != list2.tail) {
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
      if (point3.x != 0)
        result.add(point3);
    }
    while (temp1 != list1.tail) {
      result.add(temp1.getData());
      temp1 = temp1.getNext();

    }
    while (temp2 != list2.tail) {
      result.add(temp2.getData());
      temp2 = temp2.getNext();
    }
  }

  public void subtractLinked(DoublyLinkedList list1, DoublyLinkedList list2) {
    if (list1.getSize() == 0 || list2.getSize() == 0 || list1 == null || list2 == null)
      throw new RuntimeException();
    R.clear();
    NodeDL temp1;
    NodeDL temp2;
    temp1 = list1.head.getNext();
    temp2 = list2.head.getNext();

    while (temp1 != list1.tail && temp2 != list2.tail) {
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
        if (point2.x == 1)
          point3.x += -1;
        else if (point2.x == -1)
          point3.x += 1;
        else
          point3.x += -point2.x;
        point3.y = point2.y;
        temp2 = temp2.getNext();
      }
      if (point3.x != 0)
        R.add(point3);
    }

    while (temp1 != list1.tail) {
      R.add(temp1.getData());
      temp1 = temp1.getNext();
    }
    while (temp2 != list2.tail) {
      Point point = new Point(0, 0);
      point = (Point) temp2.getData();
      point.x = -point.x;
      R.add(temp2.getData());
      temp2 = temp2.getNext();
    }

  }

  public void setPoly(DoublyLinkedList list, int[][] terms) {
    int max = 10000;
    for (int i = 0; i < terms.length; i++) {
      if (terms[i][1] < 0)
        throw null;
      Point point = new Point(0, 0);
      point.x = terms[i][0];
      point.y = terms[i][1];
      if (point.y < max) {
        list.add(point);
        max = point.y;
      } else
        throw new RuntimeException();
    }
  }

  public String printPoly(DoublyLinkedList list, NodeDL node) {
    String polyy = "";
    node = list.head.getNext();
    while (node != list.tail) {
      Point point = new Point(0, 0);
      point = (Point) node.getData();
      if (node.getPrev() != list.head && point.x > 0)
        polyy += "+";

      if (point.x != 0) {
        polyy += "" + point.x;
        if (point.y == 1)
          polyy += "x";
        else if (point.y > 1)
          polyy += "x^" + point.y;

      }
      node = node.getNext();
    }
    return polyy;
  }

  public void multiplyLists(DoublyLinkedList list1, DoublyLinkedList list2) {
    R.clear();
    NodeDL temp1 = list1.head.getNext(), temp2 = list2.head.getNext();
    DoublyLinkedList templist1 = new DoublyLinkedList();
    DoublyLinkedList templist2 = new DoublyLinkedList();
    DoublyLinkedList templist3 = new DoublyLinkedList();

    while (temp1 != list1.tail) {
      Point point1 = new Point(0, 0);
      point1 = (Point) temp1.getData();
      templist1.clear();
      templist3.clear();
      temp2 = list2.head.getNext();
      while (temp2 != list2.tail) {

        Point point2 = new Point(0, 0);
        Point point3 = new Point(0, 0);
        point2 = (Point) temp2.getData();
        point3.x = point1.x * point2.x;
        point3.y = point1.y + point2.y;
        templist1.add(point3);
        temp2 = temp2.getNext();
      }
      if (templist2.head.getNext() == templist2.tail) {
        templist3.head.setNext(templist1.head.getNext());
        templist1.head.getNext().setPrev(templist3.head);
        templist3.tail.setPrev(templist1.tail.getPrev());
        templist1.tail.getPrev().setNext(templist3.tail);
      } else
        addLinked(templist1, templist2, templist3);

      templist2.head.setNext(templist3.head.getNext());
      templist3.head.getNext().setPrev(templist2.head);
      templist2.tail.setPrev(templist3.tail.getPrev());
      templist3.tail.getPrev().setNext(templist2.tail);
      temp1 = temp1.getNext();
    }
    R.head.setNext(templist2.head.getNext());
    templist2.head.getNext().setPrev(R.head);
    templist2.tail.getPrev().setNext(R.tail);
    R.tail.setPrev(templist2.tail.getPrev());
    NodeDL getSizeNode = R.head.getNext();
    while (getSizeNode != R.tail) {
      R.setSize(R.getSize() + 1);
      getSizeNode = getSizeNode.getNext();
    }
  }

}
