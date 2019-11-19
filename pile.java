public class pile<E> {
	node<E> top;
	int size;
	
	public pile() {
		this.top = null;
		this.size = 0;
	}
	
	public void push(E element) {
		node<E> aux = new node<>(element);
		
		if(size != 0) {
			aux.next = top;			
		}
		top = aux;
		size++;
	}
	
	public E pop() {
		E element = null;
		node<E> aux = top;
		
		if(!isEmpty()) {
			element = aux.element;
			top = aux.next;
			aux.next = null;
			size--;
		}
		
		return element;
	}
	
	public E top() {
		E element = null;
		
		if(!isEmpty()) {
			element = top.element;
		}
		
		return element;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return size;
	}
}
