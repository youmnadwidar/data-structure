package eg.edu.alexu.csd.datastructure.queue.cs74;

import static org.junit.Assert.*;

import org.junit.Test;

public class LQueueTest {
  final int z1 = 1, z2 = 2, z3 = 3, z4 = 4, z5 = 5, z7 = 7;
  /**
   * simple test.
   */
  @Test
  public void test() {
    LQueue test = new LQueue();
    test.enqueue(z4);
    test.enqueue(z7);
    assertEquals(z4, test.dequeue());
    assertEquals(z7, test.dequeue());
    assertTrue(test.size() == 0);
  }

  /**
   * test if dequeue when empty.
   */
  @Test(expected = RuntimeException.class)
  public void testDequeueEmpty() {
    LQueue test = new LQueue();
    test.enqueue(z4);
    test.enqueue("computer");
    test.enqueue("CSED");
    assertEquals(z4, test.dequeue());
    assertTrue(test.dequeue().equals("computer"));
    assertNotSame("computer", test.dequeue());
    assertEquals(0, test.size());
    test.dequeue();

  }

  /**
   * test isEmpty method.
   */
  @Test
  public void testisEmpty() {
    LQueue test = new LQueue();
    assertTrue(test.isEmpty());
    test.enqueue("1");
    assertFalse(test.isEmpty());
    assertEquals("1", test.dequeue());
    assertTrue(test.isEmpty());
  }

  /**
   * test size method.
   */
  @Test(expected = RuntimeException.class)
  public void testSize() {
    LQueue test = new LQueue();
    assertEquals(0, test.size());
    test.enqueue("5");
    test.enqueue("7");
    assertEquals(z2, test.size());
    test.enqueue("9");
    assertEquals(z3, test.size());
    test.dequeue();
    assertEquals(z2, test.size());
    test.dequeue();
    test.dequeue();
    assertEquals(0, test.size());
    test.dequeue();

  }
  /**
   * .
   */
@Test
public void testDE() {
  LQueue test = new LQueue();
  test.enqueue("5");
  test.enqueue("7");
  test.enqueue("9");
  test.enqueue("1");
  test.enqueue(z4);
  test.enqueue("computer");
  test.enqueue("CSED");
 assertEquals("5", test.dequeue());
 assertEquals("7", test.dequeue());
 assertEquals("9", test.dequeue());
 assertEquals("1", test.dequeue());
 assertEquals(z4, test.dequeue());
 assertEquals("computer", test.dequeue());
 assertEquals("CSED", test.dequeue());
 assertEquals(0, test.size());



}
}
