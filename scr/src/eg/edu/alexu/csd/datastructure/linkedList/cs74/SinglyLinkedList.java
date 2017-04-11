package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SinglyLinkedList implements ILinkedList {

	NodeSL head=new NodeSL (null);
	

	public SinglyLinkedList() {
		//NodeSL newnode ;
		//head = newnode;
		
	
	}

	@Override
	public void add(int index, Object element) {
		if (this.size() > index&&index>=0) {

			int count = 0;
			NodeSL current = head;
			while (count < index - 1) {
				current = current.getNext();
				count++;
			}
			NodeSL newnode = new NodeSL(element, current.getNext());

			current.setNext(newnode);
		} else {
			return;
		}

	}

	@Override
	public void add(Object element) {
		NodeSL newnode = new NodeSL(element);
		if (head == null) {//head==null head.getData ==null
			head = newnode;
		} else {
			NodeSL current = head;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(newnode);
		}
	}

	@Override
	public Object get(int index) {
		if (this.size() > index&&index>=0) {
			int count = 0;
			NodeSL current = head;
			while (count < index)
				current = current.getNext();
			return current.getData();
		}

		else {

			return null;
		}
	}

	@Override
	public void set(int index, Object element) {
		if (this.size() > index&&index>=0) {
			NodeSL current = head;
			int count = 0;
			while (count < index)
				current = current.getNext();
			current.setData(element);
		} else {
			return;
		}
	}

	@Override
	public void clear() {
		
		head=null;
		head.setNext(null);
		

	}

	@Override
	public boolean isEmpty() {
		
		if(head==null)
			return true;
		
		return false;
	}

	@Override
	public void remove(int index) {
		NodeSL v=head;
		if(this.size()>index&&index>=0){
		for(int i = 0;i<index-1;i++)
			v=v.getNext();
		v.setNext(v.getNext().getNext());
		}
		else return;
	}

	@Override
	public int size() {
		if (head == null)
			return 0;
		NodeSL current = head;
		int count = 1;
		while (current.getNext() != null)
			count++;
		return count;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		SinglyLinkedList sub=new SinglyLinkedList();
		if (this.size()>fromIndex &&this.size()>toIndex&&fromIndex>=0&&toIndex>=0&&toIndex>fromIndex){
		NodeSL current=head;
		int count=0;
		while(count<fromIndex){
			count++;
			current=current.getNext();
		}
		
		while (count<=toIndex){
			sub.add(current.getData());
			current=current.getNext();
			count++;
		}
		
	}
			return sub;
	}


	
	@Override
	public boolean contains(Object o) {
		NodeSL current=head;
		if(head==null)
			return false;
		while(current.getNext()!=null)
		{
			if(o.equals(current.getData()))
				return true;
			current=current.getNext();
		}
		return false;
	}
}

