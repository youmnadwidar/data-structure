package eg.edu.alexu.csd.datastructure.queue.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.cs74.DoublyLinkedList;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class LQueue implements IQueue, ILinkedBased {
/**
 * the list used.
 */
  private DoublyLinkedList queue = new DoublyLinkedList();
  private int size ;
  /**
   * Inserts an item at the queue front.
   * @param item
   *          that wanted to be added
   */
  public void enqueue(final Object item) {
    this.queue.add(0, item);
    this.size++;
  }
  /**
   * Removes the object at the queue rear and returns it.
   * @return the dequeued item
   */
  public Object dequeue() {
    Object item = this.queue.get(this.queue.getSize() - 1);
    this.queue.remove(this.queue.getSize() - 1);
    this.size--;
    return item;
  }

  /**
   * Tests if this queue is empty.
   * @return whether it is empty or not
   */
  public boolean isEmpty() {
    return this.queue.isEmpty();
  }

  /**
   * . Returns the number of elements in the queue.

   * @return size
   */
  public int size() {
    return this.size;
  }

}
