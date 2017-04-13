package eg.edu.alexu.csd.datastructure.linkedList.cs74;

public class NodeDL {

	private Object data;
	private NodeDL next;
	private NodeDL prev;

	public NodeDL(Object value) {
		this.data = value;
		this.next = null;

		this.prev = null;

	}

	public NodeDL(Object value, NodeDL after, NodeDL before) {
		super();
		this.data = value;
		this.next = after;
		this.prev = before;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object value) {
		this.data = value;
	}

	public NodeDL getNext() {
		return next;
	}

	public void setNext(NodeDL after) {
		this.next = after;
	}

	public NodeDL getPrev() {
		return prev;
	}

	public void setPrev(NodeDL before) {
		this.prev = before;
	}

}
