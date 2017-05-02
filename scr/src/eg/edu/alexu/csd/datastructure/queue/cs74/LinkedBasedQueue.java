package eg.edu.alexu.csd.datastructure.queue.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.cs74.DoublyLinkedList;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;

public class LinkedBasedQueue implements ILinkedBased{

  
DoublyLinkedList queue=new DoublyLinkedList();  
  
  @Override
  public void enqueue(Object item) {
queue.add(0, item);    
  }

  @Override
  public Object dequeue() {
   Object item= queue.get(queue.getSize()-1);
   queue.remove(queue.getSize()-1);
    return item;
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public int size() {
    return queue.size();
  }

}
