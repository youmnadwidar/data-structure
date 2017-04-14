package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import org.junit.Assert;
import org.junit.Test;

public class DoubleTester {

	@Test
	public void testGet() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(12);
		test.add(8);
		test.add(7);
		Assert.assertEquals(12, test.get(0));
		Assert.assertEquals(7, test.get(2));

	}

	@Test(expected = NullPointerException.class)
	public void testBiggerThanSize() {

		DoublyLinkedList test = new DoublyLinkedList();
		test.add(8);
		test.add(1);
		test.add(2);
		test.add(8, 7);

	}

	@Test(expected = NullPointerException.class)
	public void testAddNegativeindex() {

		DoublyLinkedList test = new DoublyLinkedList();
		test.add(8);
		test.add(1);
		test.add(2);
		test.add(-5, 7);

	}

	@Test
	public void testGetAndSize() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(0);
		test.add(1);
		test.add(3);
		test.remove(2);
		test.set(0, 4);
		test.add(2, 12);
		test.add(0, 30);
		Assert.assertEquals(30, test.get(0));
		Assert.assertEquals(4, test.get(1));
		Assert.assertEquals(1, test.get(2));
		Assert.assertEquals(12, test.get(3));
		Assert.assertEquals(4, test.size);

	}

	@Test(expected = RuntimeException.class)
	public void testGetNegativeIndex() {

		DoublyLinkedList test = new DoublyLinkedList();
		test.add(8);
		test.add(1);
		test.add(2);
		test.get(-5);

	}

	@Test
	public void testset() {

		DoublyLinkedList test = new DoublyLinkedList();
		test.add(8);
		test.add(1);
		test.add(2);
		test.set(2, 3);
		Assert.assertEquals(3, test.get(2));
		Assert.assertEquals(8, test.get(0));
		Assert.assertEquals(1, test.get(1));

	}

	@Test(expected = NullPointerException.class)
	public void testSetOutOfBounds() {

		DoublyLinkedList test = new DoublyLinkedList();
		test.add(8);
		test.add(1);
		test.add(2);
		test.set(-1, 5);
		test.set(50, 5);

	}

	@Test
	public void testClearAndIsEmpty() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(0);
		test.add(1);
		test.add(3);
		Assert.assertEquals(3, test.size);
		test.clear();
		Assert.assertEquals(test.tail, test.head.getNext());
		Assert.assertEquals(true, test.isEmpty());
		Assert.assertEquals(0, test.size);

	}

	@Test
	public void testRemoveHead() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(0);
		test.add(1);
		test.add(3);
		test.remove(0);
		Assert.assertEquals(1, test.get(0));

	}

	@Test(expected = NullPointerException.class)
	public void testRemoveLast() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(0);
		test.add(1);
		test.add(3);
		test.remove(2);
		Assert.assertEquals(3, test.get(2));

	}

	@Test
	public void testRemoveMiddle() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(0);
		test.add(1);
		test.add(3);
		test.remove(1);
		Assert.assertEquals(3, test.get(1));

	}

	@Test(expected = NullPointerException.class)
	public void testRemoveOut() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(0);
		test.add(1);
		test.add(3);
		test.remove(-1);
		test.remove(50);

	}

	@Test
	public void testContains() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(0);
		test.add(1);
		test.add(3);
		Assert.assertEquals(true, test.contains(0));
		Assert.assertEquals(true, test.contains(1));
		Assert.assertEquals(true, test.contains(3));
		Assert.assertEquals(false, test.contains(50));

	}

	@Test
	public void testSubList() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(20);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(6);
		Assert.assertEquals(1, test.sublist(1, 3).get(0));
		Assert.assertEquals(5, test.sublist(1, 3).get(2));
		Assert.assertEquals(20, test.sublist(0, 0).get(0));
		Assert.assertEquals(6, test.sublist(4, 4).get(0));
		Assert.assertEquals(3, test.sublist(0, 4).get(2));

	}

	@Test(expected = NullPointerException.class)
	public void testSubListFromBiggerThanTo() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(20);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(6);
		test.sublist(20, 5);

	}

	@Test(expected = NullPointerException.class)
	public void testSubListOutOfBounds() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(20);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(6);
		test.sublist(20, 25);
		test.sublist(2, 25);

	}

	@Test(expected = NullPointerException.class)
	public void testSubListNegativeIndex() {
		DoublyLinkedList test = new DoublyLinkedList();
		test.add(20);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(6);
		test.sublist(-1, 5);

	}

}
