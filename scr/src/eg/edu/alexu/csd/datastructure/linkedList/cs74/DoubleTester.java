package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import org.junit.Assert;

import org.junit.Test;
/**
 *
 * @author HP.
 * junit test for the {@link DoublyLinkedList}
 *
 */

public class DoubleTester {
  /**
   * final parameters to use in the test.
   */
  private final int z0 = 0, z1 = 1, z2 = 2, z3 = 3, z4 = 4, z5 = 5,
      z6 = 6, z7 = 7, z8 = 8,
      z12 = 12, z20 = 20, z25 = 25, z50 = 50, z30 = 30;

  /**
   * test the get method .
   */
  @Test
  public void testGet() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z12);
    test.add(z8);
    test.add(z7);
    Assert.assertEquals(z12, test.get(z0));
    Assert.assertEquals(z7, test.get(z2));

  }

  /**
   * testing add in index > size .
   */
  @Test(expected = NullPointerException.class)
  public void testBiggerThanSize() {

    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.add(z8, z7);

  }

  /**
   * test the negative index .
   */
  @Test(expected = NullPointerException.class)
  public void testAddNegativeindex() {

    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.add(-z5, z7);

  }
/**
 * testing the size and the get methods.
 */
  @Test
  public void testGetAndSize() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    test.remove(z2);
    test.set(z0, z4);
    test.add(z2, z12);
    test.add(z0, z30);
    Assert.assertEquals(z30, test.get(z0));
    Assert.assertEquals(z4, test.get(z1));
    Assert.assertEquals(z1, test.get(z2));
    Assert.assertEquals(z12, test.get(z3));
    Assert.assertEquals(z4, test.getSize());

  }
/**
 * testing the negative index .
 */
  @Test(expected = RuntimeException.class)
  public void testGetNegativeIndex() {

    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.get(-z5);

  }
/**
 * testing the set method .
 */
  @Test
  public void testset() {

    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.set(z2, z3);
    Assert.assertEquals(z3, test.get(z2));
    Assert.assertEquals(z8, test.get(z0));
    Assert.assertEquals(z1, test.get(z1));

  }
/**
 * out of bounds set method .
 */
  @Test(expected = NullPointerException.class)
  public void testSetOutOfBounds() {

    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.set(-z1, z5);
    test.set(z50, z5);

  }
/**
 * testing clear and is empty.
 */
  @Test
  public void testClearAndIsEmpty() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    Assert.assertEquals(z3, test.getSize());
    test.clear();
    Assert.assertEquals(test.getTail(), test.getHead().getNext());
    Assert.assertEquals(true, test.isEmpty());
    Assert.assertEquals(z0, test.getSize());

  }
/**
 * testing remove the head node.
 */
  @Test
  public void testRemoveHead() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    test.remove(z0);
    Assert.assertEquals(z1, test.get(z0));

  }
/**
 * testing remove the last node .
 */
  @Test(expected = NullPointerException.class)
  public void testRemoveLast() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    test.remove(z2);
    Assert.assertEquals(z3, test.get(z2));
    Assert.assertEquals(z2, test.size());

  }

  /**
   * testing remove method at the middle .
   */
  @Test
  public void testRemoveMiddle() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    test.remove(z1);
    Assert.assertEquals(z3, test.get(z1));
    Assert.assertEquals(z2, test.size());

  }

  /**
   * testing remove method with unavailable index.
   */
  @Test(expected = NullPointerException.class)
  public void testRemoveOut() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    test.remove(-z1);
    test.remove(z50);

  }

  /**
   * testing contains method.
   */
  @Test
  public void testContains() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    Assert.assertEquals(true, test.contains(z0));
    Assert.assertEquals(true, test.contains(z1));
    Assert.assertEquals(true, test.contains(z3));
    Assert.assertEquals(false, test.contains(z50));

  }

  /**
   * testing sublist method .
   */
  @Test
  public void testSubList() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z20);
    test.add(z1);
    test.add(z3);
    test.add(z5);
    test.add(z6);
    Assert.assertEquals(z1, test.sublist(z1, z3).get(0));
    Assert.assertEquals(z5, test.sublist(z1, z3).get(z2));
    Assert.assertEquals(z20, test.sublist(z0, z0).get(z0));
    Assert.assertEquals(z6, test.sublist(z4, z4).get(z0));
    Assert.assertEquals(z3, test.sublist(z0, z4).get(z2));
    Assert.assertEquals(z3, test.sublist(z1, z3).size());
    Assert.assertEquals(z1, test.sublist(z0, z0).size());

  }

  /**
   * testing sublist with unavailable toindex .
   */
  @Test(expected = NullPointerException.class)
  public void testSubListFromBiggerThanTo() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z20);
    test.add(z1);
    test.add(z3);
    test.add(z5);
    test.add(z6);
    test.sublist(z20, z5);

  }

  /**
   * testing sublist method with unavailable indexes.
   */
  @Test(expected = NullPointerException.class)
  public void testSubListOutOfBounds() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z20);
    test.add(z1);
    test.add(z3);
    test.add(z5);
    test.add(z6);
    test.sublist(z20, z25);
    test.sublist(z2, z25);

  }

  /**
   * testing the sublist method with negative index.
   */
  @Test(expected = NullPointerException.class)
  public void testSubListNegativeIndex() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z20);
    test.add(z1);
    test.add(z3);
    test.add(z5);
    test.add(z6);
    test.sublist(-z1, z5);

  }
/**
 * test adding an element in the middle .
 */
  @Test
  public final void testAddMiddle() {
    DoublyLinkedList test = new DoublyLinkedList();
    test.add(z20);
    test.add(z1);
    test.add(z3);
    test.add(z5);
    test.add(z6);
    test.add(z3, z4);
    Assert.assertEquals(z20, test.get(z0));
    Assert.assertEquals(z3, test.get(z2));
    Assert.assertEquals(z4, test.get(z3));
    Assert.assertEquals(z5, test.get(z4));
    Assert.assertEquals(z6, test.get(z5));
    Assert.assertEquals(z6, test.getSize());

  }

}
