package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author HP.
 *
 */
public class DoublyLinkedList implements ILinkedList {
  /** .
   * dummy node for the head.
   */
    NodeDL head = new NodeDL(null);
  /** .
   * dummy node for the tail.
   */
  private NodeDL tail = new NodeDL(null);
  /**.
   * size variable for the list size.
   */
  private int size;
/**.
 * constructor.
 */
  public DoublyLinkedList() {
    getHead().setNext(getTail());
    getHead().setPrev(null);
    getTail().setNext(null);
    getTail().setPrev(getHead());
    setSize(0);
  }
/**
 * the index to insert the element in.
 * @param index the place of the added node
 * the value of the inserted node
 * @param element the value of the added node
 */
  public void add(final int index, final Object element) {
    NodeDL newNode = new NodeDL(null);
    NodeDL current = getHead();
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
 * @param element the value of the added node
 */
  public void add(final Object element) {
    NodeDL newNode = new NodeDL(null);
    NodeDL current = getTail().getPrev();
    newNode.setData(element);


    current.setNext(newNode);
    newNode.setPrev(current);
    newNode.setNext(getTail());
    getTail().setPrev(newNode);
    setSize(getSize() + 1);

  }

/**
 * the index of the wanted element.
 * @param index of the wanted node
 * @return the data of the object
 */
  public Object get(final int index) {

    NodeDL current = null;

    if (this.size() > index) {
      if (index < this.size() / 2) {
        current = getHead();
        int count = 0;
        while (count <= index) {
          current = current.getNext();
          count++;
        }
      } else {
        current = getTail();
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
   * @param element the wanted set value
   */
  public final void set(final int index, final Object element) {
    NodeDL current = null;
    if (this.size() > index && index >= 0) {
      if (index < this.size() / 2) {
        current = getHead();
        int count = 0;
        while (count <= index) {
          current = current.getNext();
          count++;
        }
        current.setData(element);
      } else {
        current = getTail();
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

    this.getHead().setNext(this.getTail());
    this.getTail().setPrev(this.getHead());
    setSize(0);
  }
/**
 * check whether the list is empty.
 * @return whether it's empty or not
 */
  public boolean isEmpty() {
    return (getSize() == 0);
  }
/**
 * the index of the element that whats to be removed.
 * @param index the removed node
 */
  public void remove(final int index) {
    int count;
    if (this.size() > index && index >= 0) {
      NodeDL current;

      if (this.size() / 2 > index) {
        current = getHead().getNext();
        count = 0;
        while (count < index) {
          current = current.getNext();
          count++;
        }
      } else {
        current = getTail().getPrev();
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
   * @return the size of the linked list
   */
  public int size() {
    return this.getSize();
  }

  /**
   * Returns a view of the portion of this list between the specified.
   *  fromIndex and toIndex inclusively.
   *  @param fromIndex the start of the sublist
   *  @param toIndex  the end of the sublist
   *  @return the sublist form the specified indexes
   */

  public ILinkedList sublist(final int fromIndex, final int toIndex) {
    DoublyLinkedList sub = new DoublyLinkedList();
    if (this.size() > fromIndex && this.size() > toIndex
        && toIndex >= 0 && fromIndex >= 0
        && toIndex >= fromIndex) {
      NodeDL current = getHead().getNext();
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
 * @param o the value of the wanted node
 * @return whether it is found or not
 */
  public final boolean contains(final Object o) {
    if (this.size() != 0) {

      NodeDL current = getHead().getNext();
      while (current != getTail()) {
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
   * @return the size of the linked list getter
   */
public int getSize() {
  return size;
}
/**
 * setter for the size.
 * @param value set the size setter
 */
public void setSize(final int value) {
  this.size = value;
}
public NodeDL getHead() {
  return head;
}
public void setHead(NodeDL head) {
  this.head = head;
}
public NodeDL getTail() {
  return tail;
}
public void setTail(NodeDL tail) {
  this.tail = tail;
}

}
