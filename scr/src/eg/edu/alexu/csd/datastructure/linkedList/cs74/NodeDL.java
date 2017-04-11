package eg.edu.alexu.csd.datastructure.linkedList.cs74;

public class NodeDL {

	private Object data;
	private NodeDL next;
	private NodeDL prev;
	
	public NodeDL(Object data) {
		this.data = data;
		this.next = null;

		this.prev = null;
		
	}
	public NodeDL(Object data, NodeDL next, NodeDL prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public NodeDL getNext() {
		return next;
	}
	public void setNext(NodeDL next) {
		this.next = next;
	}
	public NodeDL getPrev() {
		return prev;
	}
	public void setPrev(NodeDL prev) {
		this.prev = prev;
	}
	
}

