package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import java.awt.List;
import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class PolynomialSolver implements IPolynomialSolver {
	DoublyLinkedList A =null;
	DoublyLinkedList B = null;
	DoublyLinkedList C = null;
	DoublyLinkedList R = null;

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		poly = Character.toUpperCase(poly);
		if (terms[0][0] == 0)
			throw new RuntimeException();
		if (poly == 'A') {
			A = new DoublyLinkedList();
			setPoly(A, terms);
		} else if (poly == 'B') {
			B = new DoublyLinkedList();
			setPoly(B, terms);
		} else if (poly == 'C') {
			C = new DoublyLinkedList();
			setPoly(C, terms);
		} else
			throw new RuntimeException();

	}

	@Override
	public String print(char poly) {
		poly = Character.toUpperCase(poly);
		NodeDL newNode = null;
		;
		if (poly == 'A' && A != null)
			return printPoly(A, newNode);

		else if (poly == 'B' && B != null)
			return printPoly(B, newNode);

		else if (poly == 'C' && C != null)
			return printPoly(C, newNode);
		// else if (poly == 'R'&&R!=null)
		// return printPoly(R, newNode);

		return null;
	}

	@Override
	public void clearPolynomial(char poly) {
		poly = Character.toUpperCase(poly);

		if (poly == 'A')
			A = null;
		else if (poly == 'B')
			B = null;
		else if (poly == 'C')
			C = null;
		else
			throw new RuntimeException();

	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		poly = Character.toUpperCase(poly);
		int answer = 0;
		NodeDL newNode;

		if (poly == 'A' && A != null) {

			newNode = A.head.getNext();
			while (newNode != A.tail) {
				Point point = new Point(0, 0);
				point = (Point) newNode.getData();
				answer += point.x * Math.pow(value, point.y);

				newNode = newNode.getNext();
			}
			return answer;
		} else if (poly == 'B' && B != null) {

			newNode = B.head.getNext();
			while (newNode != B.tail) {
				Point point = new Point(0, 0);
				point = (Point) newNode.getData();
				answer += point.x * Math.pow(value, point.y);

				newNode = newNode.getNext();
			}
			return answer;
		}

		else if (poly == 'C' && C != null) {

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
		if ((poly1 == 'A' || poly1 == 'B') && (poly2 == 'A' || poly2 == 'B')) {
			if (A == null || B == null)
				throw new RuntimeException();
			addLinked(A, B);
		}
		if ((poly1 == 'A' || poly1 == 'C') && (poly2 == 'C' || poly2 == 'A')) {
			if (A == null || C == null)
				throw new RuntimeException();
			addLinked(A, C);
		}
		if ((poly1 == 'B' || poly1 == 'C') && (poly2 == 'C' || poly2 == 'B')) {
			if (B == null || C == null)
				throw new RuntimeException();
			addLinked(B, C);
		}
		NodeDL current = R.head.getNext();
		int[][] resultArray = new int[R.size][2];
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
		if (poly1 == 'A') {
			switch (poly2) {
			case 'A':
				subtractLinked(A, A);
				break;

			case 'B':
				subtractLinked(A, B);
				break;

			case 'C':
				subtractLinked(A, C);
				break;

			default:
				throw new RuntimeException();

			}
		}
		if (poly1 == 'B') {
			switch (poly2) {
			case 'A':
				subtractLinked(B, A);
				break;

			case 'B':
				subtractLinked(B, B);
				break;

			case 'C':
				subtractLinked(B, C);
				break;

			default:
				throw new RuntimeException();

			}
		}
		if (poly1 == 'C') {
			switch (poly2) {
			case 'A':
				subtractLinked(C, A);
				break;

			case 'B':
				subtractLinked(C, B);
				break;

			case 'C':
				subtractLinked(C, C);
				break;

			default:
				throw new RuntimeException();

			}
		}
		NodeDL current = R.head.getNext();
		int[][] resaultArray = new int[R.size][2];
		for (int i = 0; i < resaultArray.length; i++) {
			Point point = new Point();
			point = (Point) current.getData();
			resaultArray[i][0] = point.x;
			resaultArray[i][1] = point.y;
			current = current.getNext();

		}
		return resaultArray;

	}

	@Override
	public int[][] multiply(char poly1, char poly2) {

		return null;
	}

	public void addLinked(DoublyLinkedList list1, DoublyLinkedList list2) {
		if(list1==null||list2==null)
			throw new RuntimeException();
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
			R.add(point3);
		}
		while (temp1 != list1.tail) {
			R.add(temp1.getData());
			temp1 = temp1.getNext();

		}
		while (temp2 != list2.tail) {
			R.add(temp2.getData());
			temp2 = temp2.getNext();
		}
	}

	public void subtractLinked(DoublyLinkedList list1, DoublyLinkedList list2) {
		R = new DoublyLinkedList();
		if (list1.size == 0 || list2.size == 0)
			throw new RuntimeException();
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
				point3.x = point1.x - point2.x;
				point3.y = point1.y;

				temp1 = temp1.getNext();
				temp2 = temp2.getNext();

			} else if (point1.y > point2.y) {
				point3.x = point1.x;
				point3.y = point1.y;

				temp1 = temp1.getNext();
			} else {
				point3.x = -point2.x;
				point3.y = point2.y;
				temp2 = temp2.getNext();
			}

			R.add(point3);

		}

		while (temp1 != list1.tail) {
			R.add(temp1.getData());

			temp1 = temp1.getNext();
		}
		while (temp2 != list2.tail) {

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
				polyy += " + ";

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
}