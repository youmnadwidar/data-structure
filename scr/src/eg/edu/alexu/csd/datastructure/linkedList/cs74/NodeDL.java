package eg.edu.alexu.csd.datastructure.linkedList.cs74;
/**
 *
 * @author HP.
 *
 */
public class NodeDL {
/**
 * the data stored in the node.
 */
  private Object data;
  /**
   * the node which follows.
   */
  private NodeDL next;
  /**
   * the node before the current.
   */
  private NodeDL prev;
  /**
   * constructor for the node.
   * @param value
   */

  public NodeDL(final Object value) {
    this.data = value;
    this.next = null;

    this.prev = null;

  }
/**
 * 
 * @param value.
 * @param after
 * @param before
 */
  public NodeDL(final Object value, final NodeDL after, final NodeDL before) {
    super();
    this.data = value;
    this.next = after;
    this.prev = before;
  }
/**
 * 
 * @return.
 */
  public final Object getData() {
    return data;
  }
/**
 * 
 * @param value.
 */
  public final void setData(final Object value) {
    this.data = value;
  }
/**
 * getter.
 * @return
 */
  public final NodeDL getNext() {
    return next;
  }
/**
 * setter.
 * @param after
 */
  public final void setNext(final NodeDL after) {
    this.next = after;
  }
/**
 * getter.
 * @return.
 */
  public final NodeDL getPrev() {
    return prev;
  }
/**
 * setter.
 * @param before
 */
  public final void setPrev(final NodeDL before) {
    this.prev = before;
  }

}
