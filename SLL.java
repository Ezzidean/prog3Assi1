import java.util.Comparator;

public class SLL<T extends Comparable<T>>  {
	
	private Node<T> head, tail;
	private int size;
	private Comparator<T> comparator;
	
	public SLL() {
		head = null;
		tail = null;
		comparator = null;
		size = 0;
	}
	public SLL(Comparator<T> comparator) {
		this.comparator = comparator;
		head = null;
		tail = null;
		size = 0;
	}

	// Public Methods

	/**
	 * Return the number of elements in the list.
	 * 
	 * @return int number of elements in the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Empty the list.
	 */
	public void emptyList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Add a new object t to the head of the list.
	 * 
	 * @param t the object to add.
	 */
	public void addHead(T t) {
		addHead(new Node<T>(t));
	}
	
	public void addTail(T t) {
		addTail(new Node<T>(t));
	}

	/**
	 * Return head value
	 * 
	 * @return head value, null if list is empty
	 */
	public T getHead() {
		if (head == null)
			return null;
		else
			return head.getData();
	}

	/**
	 * Return tail value
	 * 
	 * @return tail value, null if list is empty
	 */
	public T getTail() {
		if (tail == null)
			return null;
		else
			return tail.getData();
	}

	/**
	 * Delete the element at the head of the list.
	 * 
	 * @return the deleted element.
	 */
	public T deleteHead() {
		Node<T> n = delHead();
		if (n == null)
			return null;
		else
			return n.getData();
	}

	/**
	 * Return the ith element of the list.
	 * 
	 * @param i the element to return
	 * @return the ith element, null if there isnt one.
	 */
	public T get(int i) {
		Node<T> curr = head;
		int j = 0;
		while (curr != null && j < i) {
			curr = curr.getNext();
			j++;
		}
		if (curr != null)
			return curr.getData();
		else
			return null;
	}

	// Private methods

	/*
	 * Add a new Node to the head of the list.
	 */
	private void addHead(Node<T> n) {
		if (head == null) // empty list
		{
			head = n;
			tail = n;
		} else {
			n.setNext(head);
			head = n;
		}
		size++;
	}
	private void addTail(Node<T> n) {
		if(tail == null) {
			addHead(n);
		}else {
			tail.setNext(n);
			tail = n;
		}
		size ++;
	}

	/*
	 * Delete the node at the head of the list and return a pointer to it.
	 */
	private Node<T> delHead() {
		Node<T> n = null;
		if (head != null) {
			n = head;
			if (head == tail)
				tail = head.getNext();
			head = head.getNext();
			size--;
		}
		return n;
	}
	
	public void addInOrder(T  t) {
		
		if(head == null) {
			addHead(t);
			return;
		}
		
		if(comparator != null) {
		    
			if(comparator.compare(getHead(), t) == 1) {
				addHead(t);
				return;
			}else if(comparator.compare(getTail(), t) < 0) {
				addTail(t);
				return;
			}else {
				compare(t);
				return;
			}
			
			
		}else {
			
			addTail(t);
		}

		}
	public void compare(T t) {
		Node<T> newNode = new Node<T>(t);
		Node<T> currentNode = head;
		while(currentNode.getNext()!= null) {
			if(comparator.compare(currentNode.getNext().getData(),t) > 0) {
				newNode.setNext(currentNode.getNext());
				currentNode.setNext(newNode);
				break;
			}
			currentNode = currentNode.getNext();
			
		}
		
	}
		
	public void printSLL() {
		Node<T> currentNode = head;
		
		while(currentNode!= null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
		}
	}
	public void printSLL(int limit) {
		Node<T> currentNode = head;
		int index = 0;
		while(currentNode!= null && index < limit) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
			index++;
		}
	}


}