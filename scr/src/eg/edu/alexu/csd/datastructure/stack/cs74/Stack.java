package eg.edu.alexu.csd.datastructure.stack.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.cs74.DoublyLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;

public class Stack implements IStack {
 
  DoublyLinkedList stack=new DoublyLinkedList();
  @Override
  /**
   * Inserts a specified element at the specified position in the list.
   * @param index zero-based index
   * @param element object to insert
   */
  public void add(int index, Object element) {
    
    stack.add(index, element);
    
  }

  @Override
  /**
  * Removes the element at the top of stack and returns that element.
  * @return top of stack element, or through exception if empty
  */
  public Object pop() {
    //b y throw runtime exception f el linked list w mosh 3rfaa howa 3awz eh  
    Object element =stack.get(stack.getSize()-1);
    stack.remove(stack.getSize()-1);
    return element;
  }

  @Override
  
  /**
   * Get the element at the top of stack without removing it from stack.
   * @return top of stack element, or through exception if empty
   */
  public Object peek() {
    
    return stack.get(stack.getSize()-1);

  }

  @Override
  /**
   * Pushes an item onto the top of this stack.
   * @param object to insert
   */
  public void push(Object element) {
stack.add(element);    
  }

  @Override
  /**
   * Tests if this stack is empty
   * @return true if stack empty
   */
  public boolean isEmpty() {
   
    return stack.isEmpty();
  }

  @Override
  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */
  public int size() {
    
    return stack.getSize();
  }
public void print(){
  for (int i = 0; i < stack.getSize(); i++) {
    System.out.println(stack.get(i));
    
  }
}
}

