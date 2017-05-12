package eg.edu.alexu.csd.datastructure.linkedList;
/**
 *
 * @author HP.
 *
 */
public interface ILinkedList {

  /**
   * Inserts a specified element at the specified position in the list.
   * @param index of the inserted element.
   * @param element the added value.
   */
  void add(int index, Object element);

  /** Inserts the specified element at the end of the list.
   * @param element the added value.
   */
  void add(Object element);

  /** Returns the element at the specified position in this list.
   *@param index the index of the wanted element.
   *@return the element
   */
  Object get(int index);

  /**
   * Replaces the element at the specified position in
   *this list with the specified element.
   *@param index the index of the set element
   * @param element the changed value.
   */
  void set(int index, Object element);

  /** Removes all of the elements from this list.
   */
  void clear();

  /** @return true if this list contains no elements.
   */
  boolean isEmpty();

  /** Removes the element at the specified position in this list.
   * @param index the index of the removed element.
   */
  void remove(int index);

  /** Returns the number of elements in this list.
   * @return size
   */
  int size();

  /**
   * Returns a view of the portion of this list between.
   *  the specified fromIndex and toIndex,
   * inclusively.
   * @param fromIndex the started index.
   * @param toIndex the ended index.
   * @return sublist from specified index to another.
   */
  ILinkedList sublist(int fromIndex, int toIndex);

  /**
   * Returns true if this list contains an element with.
   *  the same value as the specified element.
   * @param o the value of the element.
   * @return whether exist or not.
   */
  boolean contains(Object o);

}
