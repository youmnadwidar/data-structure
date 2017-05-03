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
    if (size == maxLenght) {
      throw null;
    }
    r = (r + 1);
    size++;
    if (r >= maxLenght ) {
      r %= maxLenght;

    }
    queue[r] = item;
    
  }

  /**
   * Removes the object at the queue rear and returns it.
   * 
   * @return the dequeued item
   */
  public Object dequeue() {
    if (size ==0) {
      throw null;
    } f = (f + 1);
    size--;
    if (f >= maxLenght ) {
      f %= maxLenght;
    }
    Object item = queue[f];
    queue[f] = null;
   
    return item;
  }

  /**
   * Tests if this queue is empty.
   * 
   * @return whether it is empty or not
   */
  public boolean isEmpty() {

    return size==0;
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
