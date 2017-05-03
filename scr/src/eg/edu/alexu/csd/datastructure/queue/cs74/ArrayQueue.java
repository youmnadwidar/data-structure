package eg.edu.alexu.csd.datastructure.queue.cs74;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class ArrayQueue implements IQueue, IArrayBased {

  int f;
  int r;
  int size;
  int maxLenght;
  Object[] queue;

  /**
   * @param number max number of the array size .
   */
  public ArrayQueue(final int number) {
    this.maxLenght = number;
    f = -1;
    r = -1;
    size = 0;
    queue = new Object[maxLenght];
  }

  /**
   * Inserts an item at the queue front.
   * 
   * @param item
   *          that wanted to be added
   */
  public void enqueue(final Object item) {
    if (r == maxLenght - 1) {
      throw new NullPointerException();
    }
    queue[r + 1] = item;
    r = (r + 1);
    size++;
    if (r >= size && size!=0) {
      r %= size;
    }

  }

  /**
   * Removes the object at the queue rear and returns it.
   * 
   * @return the dequeued item
   */
  public Object dequeue() {
    if (f == r) {
      return null;
    }
    Object item = queue[f + 1];
    queue[f + 1] = null;
    f = (f + 1);
    size--;
    if (f >= size && size!=0) {
      f %= size;
    }
    return item;
  }

  /**
   * Tests if this queue is empty.
   * 
   * @return whether it is empty or not
   */
  public boolean isEmpty() {

    return f == r;
  }

  /**
   * . Returns the number of elements in the queue.
   * 
   * @return size of the queue
   */
  public int size() {
    return size;
  }

}
