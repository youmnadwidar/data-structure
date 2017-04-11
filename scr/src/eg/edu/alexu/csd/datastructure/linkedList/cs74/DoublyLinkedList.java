package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DoublyLinkedList implements ILinkedList {
	NodeDL head=new NodeDL (null);
	NodeDL tail=new NodeDL (null);
	
	public DoublyLinkedList() {
		head.setNext(tail);
		head.setPrev(null);
		tail.setNext(null);
		tail.setPrev(head);
	}

	@Override
	public void add(int index, Object element) {
		NodeDL newNode =new NodeDL(null);
		NodeDL current=head;
		newNode.setData(element);
		if(this.size()>index)
		{
			int count=0;
			while(count<index){
				current=current.getNext();
				count++;
			}
			newNode.setPrev(current);
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
		else
			return;
		
	}

	@Override
	public void add(Object element) {
		NodeDL newNode =new NodeDL(null);
		NodeDL current=head;
		newNode.setData(element);
		
		while(current.getNext()!=tail)
			current=current.getNext();
		
		current.setNext(newNode);
		newNode.setPrev(current);
		newNode.setNext(tail);
		tail.setPrev(newNode);

	}

	@Override
	public Object get(int index) {
		
		NodeDL current=null;
		
		if(this.size()>index)
		{
			if(index<this.size()/2)
			{
				current=head;
				int count=0;
				while(count<=index){
					current=current.getNext();
					count++;
				}
			}
			else{
				current=tail;
				int count=this.size();
				while(count>index){
					current=current.getPrev();
					count--;
				}
			}
		}
		return current.getData(); 
	}

	@Override
	public void set(int index, Object element) {
		NodeDL current=null;
		if(this.size()<index)
		{
			if(index<this.size()/2)
			{
				current=head;
				int count=0;
				while(count<=index){
					current=current.getNext();
					count++;
				}
				current.setData(element);
			}
			else{
				current=tail;
				int count=this.size();
				while(count>index){
					current=current.getPrev();
					count--;
				}
				current.setData(element);
			}
		}
		
	}

	@Override
	public void clear() {
		
		head.setNext(tail);
		tail.setPrev(head);
	}

	@Override
	public boolean isEmpty() {
		if (head.getNext()==null)
			return true;
		else{
		return false;
		}
	}

	@Override
	public void remove(int index) {
		int count;
		if (this.size()>index)
		{
			NodeDL current;
			
			if(this.size()/2>index){
				current=head.getNext();
				count=0;
				while(count<index){
					current=current.getNext();
					count++;
				}
			}
				else {
					current=tail.getPrev();
					count=this.size()-1;
					while(count>index){
						count--;   
						current=current.getPrev();
					}
				}
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(current.getPrev());
			current=null;
				
			}
		}
		
	

	@Override
	public int size() {
		int count=0;
		NodeDL newNode=head;
		while(newNode.getNext()!=tail)
			count++;
		return count;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		DoublyLinkedList sub =new DoublyLinkedList();
		if(this.size()>fromIndex&&this.size()>toIndex&&toIndex>=0&&fromIndex>=0&&toIndex>fromIndex)
		{
			NodeDL current=head.getNext();
			int count=0;
			while(count<fromIndex)
			{
				current=current.getNext();
				count++;
			}
		
			
			while(count<=toIndex)
			{
				sub.add(current.getData());
				current=current.getNext();
				count++;
			}
		}
		return sub;
	}

	
	public boolean contains(Object o) {
		if (this.size()!=0){
		
			NodeDL current=head.getNext();
			while (current!=tail){
				if (o.equals(current.getData()))
					return true;
				else {
					current=current.getNext();
				}
			
		}
		}
		return false ;
	}
	
}
