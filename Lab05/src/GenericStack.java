import java.util.ArrayList;

//Lab 5 Generics
class GenericStack<E> extends ArrayList<E> {
	
	public void push(E value) {
		add(value);
	}
	
	public E pop() {
		return remove(size() - 1);
	}
	
	public E peek() {
		return get(size()-1);
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int getSize() {
		return size();
	}
}

