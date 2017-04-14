package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import org.junit.Assert;
import org.junit.Test;

public class SingleTester {
  private final int z0 = 0, z1 = 1, z2 = 2, z3 = 3, z4 = 4, z5 = 5, z6 = 6, z7 = 7, z8 = 8, z9 = 9,
      z12 = 12, z20 = 20, z25 = 25, z50 = 50, z30 = 30;

  @Test
  public void testGet() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z12);
    test.add(z8);
    test.add(z7);
    Assert.assertEquals(z12, test.get(z0));
    Assert.assertEquals(z7, test.get(z2));

  }

  @Test(expected = NullPointerException.class)
  public void testBiggerThanSize() {

    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.add(z8, z7);

  }

  @Test(expected = NullPointerException.class)
  public void testAddNegativeindex() {

    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.add(-z5, z7);

  }

  @Test
  public void testGetAndSize() {
    SinglyLinkedList test = new SinglyLinkedList();
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
    Assert.assertEquals(z4, test.size);

  }

  @Test(expected = NullPointerException.class)
  public void testGetNegativeIndex() {

    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.get(-z5);

  }

  @Test
  public void testset() {

    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.set(z2, z3);
    Assert.assertEquals(z3, test.get(z2));
    Assert.assertEquals(z8, test.get(z0));
    Assert.assertEquals(z1, test.get(z1));
  }

  @Test(expected = NullPointerException.class)
  public void testSetOutOfBounds() {

    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z8);
    test.add(z1);
    test.add(z2);
    test.set(-z1, z5);
    test.set(z50, z5);

  }

  @Test
  public void testClearAndIsEmpty() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    Assert.assertEquals(z3, test.size);
    test.clear();
    Assert.assertEquals(null, test.head.getNext());
    Assert.assertEquals(true, test.isEmpty());
    Assert.assertEquals(z0, test.size);
  }

  @Test
  public void testRemoveHead() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    test.remove(z0);
    Assert.assertEquals(z1, test.get(z0));

  }

  @Test(expected = NullPointerException.class)
  public void testRemoveLast() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    test.remove(z2);
    Assert.assertEquals(z3, test.get(z2));
    Assert.assertEquals(z2, test.size());

  }

  @Test
  public void testRemoveMiddle() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    test.remove(z1);
    Assert.assertEquals(z3, test.get(z1));
    Assert.assertEquals(z2, test.size());

  }

  @Test(expected = NullPointerException.class)
  public void testRemoveOut() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    test.remove(-z1);
    test.remove(z50);
  }

  @Test
  public void testContains() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z0);
    test.add(z1);
    test.add(z3);
    Assert.assertEquals(true, test.contains(z0));
    Assert.assertEquals(true, test.contains(z1));
    Assert.assertEquals(true, test.contains(z3));
    Assert.assertEquals(false, test.contains(z50));

  }

  @Test
  public void testSubList() {
    SinglyLinkedList test = new SinglyLinkedList();
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

  @Test(expected = NullPointerException.class)
  public void testSubListFromBiggerThanTo() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z20);
    test.add(z1);
    test.add(z3);
    test.add(z5);
    test.add(z6);
    test.sublist(z20, z5);

  }

  @Test(expected = NullPointerException.class)
  public void testSubListOutOfBounds() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z20);
    test.add(z1);
    test.add(z3);
    test.add(z5);
    test.add(z6);
    test.sublist(z20, z25);
    test.sublist(z2, z25);
  }

  @Test(expected = NullPointerException.class)
  public void testSubListNegativeIndex() {
    SinglyLinkedList test = new SinglyLinkedList();
    test.add(z20);
    test.add(z1);
    test.add(z3);
    test.add(z5);
    test.add(z6);
    test.sublist(-z1, z5);

  }

  @Test
  public void testAddMiddle() {
    SinglyLinkedList test = new SinglyLinkedList();
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
    Assert.assertEquals(z6, test.size);

  }

}
