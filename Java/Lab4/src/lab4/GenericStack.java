//Jason Rutledge
//Lab 4
//Purpose: Generate a generic array with stack implementation

package lab4;

import java.lang.reflect.Array;

public class GenericStack<E> {
	private int lastIndex = 0, maxSize = 0;
	private E[] list;
	
	//No default constructor as type must be given
	
	//Generate the array based on class and desired size
	//Error if the size is 0 or less
	@SuppressWarnings("unchecked")
	public GenericStack(Class<E[]> classType, int _maxSize) {	
		if (_maxSize <= 0) {
			System.out.println("Size of the array must be 1 or greater");
			System.exit(1);
		}
		this.maxSize = _maxSize;
		this.list = (E[]) Array.newInstance(classType.getComponentType(), _maxSize);	
	}
	
	public int getSize() {
		return lastIndex;
	}

	public E peek() {
		return list[lastIndex - 1];
	}
	
	@SuppressWarnings("unchecked")
	public void push(E o) {
		//Double array size if adding an element currently out of bounds
		if (lastIndex == maxSize) {
			//Create an array of the same type with double the size
			E[] temp = (E[]) Array.newInstance(list[0].getClass(), maxSize * 2);
			
			for (int i = 0; i < lastIndex; i++)
				temp[i] = list[i];
			
			this.list = temp;	
			this.maxSize = maxSize * 2;
		}
		
		list[lastIndex] = o;
		lastIndex++;
	}
	
	public E pop() {
		E o = list[lastIndex - 1];
		list[lastIndex - 1] = null;
		lastIndex--;
		return o;			
	}
	
	public boolean isEmpty() {
		if (lastIndex == 0)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		String arrString = "";
		for (E item: list)
			arrString = arrString + item + " ";
		
		return "stack: " + arrString;
	}	
	
}
