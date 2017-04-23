package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DoublyLinkedList implements ILinkedList {
  /** .
   * dummy node for the head.
   */
  NodeDL head = new NodeDL(null);
  /** .
   * dummy node for the tail.
   */
  NodeDL tail = new NodeDL(null);
  /**.
   * size variable for the list size.
   */
  private int size;
/**.
 * constructor.
 */
  public DoublyLinkedList() {
    head.setNext(tail);
    head.setPrev(null);
    tail.setNext(null);
    tail.setPrev(head);
    setSize(0);
  }
/**
 * the index to insert the element in.
 * @param index
 * the value of the inserted node
 * @param element
 */
  public void add(final int index, final Object element) {
    NodeDL newNode = new NodeDL(null);
    NodeDL current = head;
    newNode.setData(element);
    if (this.size() >= index && index >= 0) {

      int count = 0;
      while (count < index) {

        current = current.getNext();
        count++;
      }
      newNode.setPrev(current);
      newNode.setNext(current.getNext());
      current.getNext().setPrev(newNode);
      current.setNext(newNode);

      setSize(getSize() + 1);
    } else {
      throw null;
    }

  }
/**
 * the value of the inserted node.
 * @param element 
 */
  public void add(final Object element) {
    NodeDL newNode = new NodeDL(null);
    NodeDL current = tail.getPrev();
    newNode.setData(element);

   

    current.setNext(newNode);
    newNode.setPrev(current);
    newNode.setNext(tail);
    tail.setPrev(newNode);
    setSize(getSize() + 1);

  }

/**
 * the index of the wanted element.
 * @param index
 * @return the data of the object
 */
  public Object get(final int index) {

    NodeDL current = null;

    if (this.size() > index) {
      if (index < this.size() / 2) {
        current = head;
        int count = 0;
        while (count <= index) {
          current = current.getNext();
          count++;
        }
      } else {
        current = tail;
        int count = this.size();
        while (count > index) {
          current = current.getPrev();
          count--;
        }
      }
      if (current.getData() == null || current == null) {
        throw new RuntimeException();
      }

      return current.getData();

    } else {
      throw null;
    }
  }
  /**
   * the index of the node.
   * @param index
   * the value of the node 
   * @param element
   */
  public final void set(final int index, final Object element) {
    NodeDL current = null;
    if (this.size() > index && index >= 0) {
      if (index < this.size() / 2) {
        current = head;
        int count = 0;
        while (count <= index) {
          current = current.getNext();
          count++;
        }
        current.setData(element);
      } else {
        current = tail;
        int count = this.size();
        while (count > index) {
          current = current.getPrev();
          count--;
        }
        current.setData(element);
      }
    } else {
      throw null;
    }

  }
  /**
   * clear the linkedlist.
   */
  
  public void clear() {

    this.head.setNext(this.tail);
    this.tail.setPrev(this.head);
    setSize(0);
  }
/**
 * check whether the list is empty.
 */
  public boolean isEmpty() {
    return (getSize() == 0);
  }
/**
 * the index of the element that whats to be removed.
 * @param index
 */
  public void remove(final int index) {
    int count;
    if (this.size() > index && index >= 0) {
      NodeDL current;

      if (this.size() / 2 > index) {
        current = head.getNext();
        count = 0;
        while (count < index) {
          current = current.getNext();
          count++;
        }
      } else {
        current = tail.getPrev();
        count = this.size() - 1;
        while (count > index) {
          count--;
          current = current.getPrev();
        }
      }
      current.getPrev().setNext(current.getNext());
      current.getNext().setPrev(current.getPrev());
      current = null;
      setSize(getSize() - 1);

    } else {
      throw null;
    }
  }
  /**
   * the size of the linked list.
   * @return
   */
  public int size() {
    return this.getSize();
  }

  /**
   * Returns a view of the portion of this list between the specified.
   *  fromIndex and toIndex inclusively.
   *  @param from index
   *  @param toindex;
   */

  public ILinkedList sublist(final int fromIndex, final int toIndex) {
    DoublyLinkedList sub = new DoublyLinkedList();
    if (this.size() > fromIndex && this.size() > toIndex 
        && toIndex >= 0 && fromIndex >= 0
        && toIndex >= fromIndex) {
      NodeDL current = head.getNext();
      int count = 0;
      while (count < fromIndex) {
        current = current.getNext();
        count++;
      }

      while (count <= toIndex) {
        sub.add(current.getData());
        current = current.getNext();
        count++;
      }
      return sub;

    }
    throw null;
  }
/**
 * the value of the node.
 * @param o
 * @return whether it is found or not
 */
  public final boolean contains(final Object o) {
    if (this.size() != 0) {

      NodeDL current = head.getNext();
      while (current != tail) {
        if (o.equals(current.getData())) {
          return true;
        } else {
          current = current.getNext();
        }

      }
    }
    return false;
  }
  /**
   * getter for the size.
   * @return
   */
public int getSize() {
  return size;
}
/**
 * setter for the size.
 * @param size
 */
public void setSize(final int size) {
  this.size = size;
}

}
