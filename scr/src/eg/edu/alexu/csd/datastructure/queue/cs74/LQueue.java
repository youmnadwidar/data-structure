package eg.edu.alexu.csd.datastructure.queue.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.cs74.DoublyLinkedList;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class LQueue implements IQueue,ILinkedBased{

  
DoublyLinkedList queue=new DoublyLinkedList();  
  
  
  public void enqueue(Object item) {
queue.add(0, item);    
  }

  public Object dequeue() {
   Object item= queue.get(queue.getSize()-1);
   queue.remove(queue.getSize()-1);
    return item;
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  
  public int size() {
    return queue.size();
  }

}
