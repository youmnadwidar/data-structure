package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**
 * .
 * @author HP
 *
 */
public class SinglyLinkedList implements ILinkedList {
/**
 * .
 */
  NodeSL head = new NodeSL(null);
  /**
   * .
   */
 int size;
/**
 * .
 */
  public SinglyLinkedList() {
    head = null;
    size = 0;

  }
/**
 * add.
 * @param index  .
 * @param element   .
 */
  public void add(final int index, final Object element) {
    NodeSL newnode = new NodeSL(element);

    if (this.size >= index && index >= 0) {
      if (index == 0) {

        newnode.setNext(head);
        head = newnode;
        size++;
        return;
      }
      int count = 0;
      NodeSL current = head;
      while (count < index - 1) {
        current = current.getNext();
        count++;
      }
      newnode = new NodeSL(element, current.getNext());

      current.setNext(newnode);
      size++;
    } else {
      throw null;
    }

  }
/**
 * add.
 * @param element  .
 */
  public void add(final Object element) {
    NodeSL newnode = new NodeSL(element);
    if (head == null) {
      head = newnode;
    } else {
      NodeSL current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newnode);
    }
    size++;

  }
/**
 * get.
 * @param index  .
 * @return  .
 */
  public Object get(final int index) {
    if (this.size > index && index >= 0) {
      int count = 0;
      NodeSL current;
      current = head;
      while (count < index) {
        current = current.getNext();
        count++;
      }
      return current.getData();
    } else {

      throw null;
    }
  }
/**
 * set.
 * @param index .
 * @param element  .
 */
  public void set(final int index, final Object element) {
    if (this.size > index && index >= 0) {
      NodeSL current = head;
      int count = 0;
      while (count < index) {
        current = current.getNext();
        count++;
      }
      current.setData(element);
    } else {
      throw null;
    }
  }
/**
 * clear .
 */
  public void clear() {
    head.setNext(null);
    head = null;
    size = 0;

  }
/**
 * is empty or not .
 * @return  .
 */
  public boolean isEmpty() {

    return (size == 0);
  }
/**
 * remove .
 * @param index  .
 */
  public void remove(final int index) {
    NodeSL v = head;
    if (index == 0) {
      head = head.getNext();
      size--;
      return;
    }
    if (this.size > index && index > 0) {

      for (int i = 0; i < index - 1; i++) {
        v = v.getNext();
      }
      v.setNext(v.getNext().getNext());
      size--;
    } else {
      throw null;
    }
  }
/**
 * @return size.
 */
  public int size() {
    return this.size;
  }
/**
 * @param fromIndex .
 * @param toIndex  .
 * @return sublist .
 */
  public ILinkedList sublist(final int fromIndex, final int toIndex) {
    SinglyLinkedList sub = new SinglyLinkedList();
    if (this.size() > fromIndex && this.size() > toIndex
        && fromIndex >= 0 && toIndex >= 0
        && toIndex >= fromIndex) {
      NodeSL current = head;
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
 * @param o exists.
 * @return exist or not.
 */
  public boolean contains(final Object o) {
    NodeSL current = head;

    while (current != null) {
      if (o.equals(current.getData())) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }
}
