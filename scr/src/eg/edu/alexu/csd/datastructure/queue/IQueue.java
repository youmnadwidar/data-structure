package eg.edu.alexu.csd.datastructure.queue;

public interface IQueue {
  /**
   * Inserts an item at the queue front.
   * 
   * @param item
   *          that wanted to be added
   */
  public void enqueue(Object item);

  /**
   * Removes the object at the queue rear and returns it.
   * 
   * @return the dequeued item
   */
  public Object dequeue();

  /**
   * Tests if this queue is empty.
   * 
   * @return whether it is empty or not
   */
  public boolean isEmpty();

  /**
   * . Returns the number of elements in the queue.
   * 
   * @return size
   */
  public int size();
}
