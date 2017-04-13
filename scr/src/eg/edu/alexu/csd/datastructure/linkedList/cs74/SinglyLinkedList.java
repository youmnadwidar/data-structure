package eg.edu.alexu.csd.datastructure.linkedList.cs74;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SinglyLinkedList implements ILinkedList {

	NodeSL head = new NodeSL(null);
	int size;

	public SinglyLinkedList() {
		head = null;
		size = 0;

	}

	public void add(int index, Object element) {
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

	public void add(Object element) {
		NodeSL newnode = new NodeSL(element);
		if (head == null) {
			head = newnode;
		} else {
			NodeSL current = head;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(newnode);
		}
		size++;

	}

	public Object get(int index) {
		if (this.size > index && index >= 0) {
			int count = 0;
			NodeSL current;
			current = head;
			while (count < index) {
				current = current.getNext();
				count++;
			}
			return current.getData();
		}

		else {

			throw null;
		}
	}

	public void set(int index, Object element) {
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

	public void clear() {
		head.setNext(null);
		head = null;
		size = 0;

	}

	public boolean isEmpty() {

		return (size==0);
	}

	public void remove(int index) {
		NodeSL v = head;
		if (index == 0) {
			head = head.getNext();
			size--;
			return;
		}
		if (this.size > index && index > 0) {
			
			for (int i = 0; i < index - 1; i++)
				v = v.getNext();
			v.setNext(v.getNext().getNext());
			size--;
		} else
			throw null;
	}

	public int size() {
		return this.size;
	}

	public ILinkedList sublist(int fromIndex, int toIndex) {
		SinglyLinkedList sub = new SinglyLinkedList();
		if (this.size() > fromIndex && this.size() > toIndex && fromIndex >= 0 && toIndex >= 0
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

	public boolean contains(Object o) {
		NodeSL current = head;
		
		while (current != null) {
			if (o.equals(current.getData()))
				return true;
			current = current.getNext();
		}
		return false;
	}
}
