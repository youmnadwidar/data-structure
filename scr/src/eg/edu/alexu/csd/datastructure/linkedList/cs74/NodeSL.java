package eg.edu.alexu.csd.datastructure.linkedList.cs74;

public class NodeSL {

	private Object data;

	private NodeSL next;

	public NodeSL(Object value) {
		this.data = value;
		this.next = null;
	}

	public NodeSL(Object value, NodeSL after) {

		this.data = value;
		this.next = after;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object value) {
		this.data = value;
	}

	public NodeSL getNext() {
		return next;
	}

	public void setNext(NodeSL after) {
		this.next = after;
	}

}
