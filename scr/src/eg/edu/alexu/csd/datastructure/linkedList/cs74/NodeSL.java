package eg.edu.alexu.csd.datastructure.linkedList.cs74;

public class NodeSL {
	
    private Object data ;
    
	private NodeSL next;
	
	
	public NodeSL(Object data){
		this.data=data;
		this.next=null;
	}
	public NodeSL(Object data, NodeSL next) {
	
		this.data = data;
		this.next = next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public NodeSL getNext() {
		return next;
	}
	public void setNext(NodeSL next) {
		this.next = next;
	}
	
	
	
	
}
