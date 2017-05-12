package eg.edu.alexu.csd.datastructure.linkedList.cs74;
/**
 * .
 * @author HP
 *
 */
public class NodeSL {
/**
 * data of the node.
 */
  private Object data;
  /**

   */

  private NodeSL next;
/**
 * .
 * @param value the value of the elemnt.
 */
  public NodeSL(final Object value) {
    this.data = value;
    this.next = null;
  }
/**
 * @param value .
 * @param after .
 */
  public NodeSL(final Object value, final NodeSL after) {

    this.data = value;
    this.next = after;
  }
/**
 *
 * @return .
 */
  public Object getData() {
    return data;
  }
/**
 * setter.
 * @param value .
 */
  public void setData(final Object value) {
    this.data = value;
  }
/**
 *
 * @return next.
 */
  public NodeSL getNext() {
    return next;
  }
/**
 *.
 * @param after .
 */
  public void setNext(final NodeSL after) {
    this.next = after;
  }

}
