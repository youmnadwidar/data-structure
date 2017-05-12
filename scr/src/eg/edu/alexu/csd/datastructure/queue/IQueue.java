package eg.edu.alexu.csd.datastructure.queue;
/**
 *.
 * @author HP.
 *
 */
public interface IQueue {
  /**
   * Inserts an item at the queue front.
   * @param item
   *          that wanted to be added
   */
  void enqueue(Object item);

  /**
   * Removes the object at the queue rear and returns it.
   * @return the dequeued item
   */
  Object dequeue();

  /**
   * Tests if this queue is empty.
   * @return whether it is empty or not
   */
  boolean isEmpty();

  /**
   * . Returns the number of elements in the queue.
   * @return size
   */
  int size();
}
