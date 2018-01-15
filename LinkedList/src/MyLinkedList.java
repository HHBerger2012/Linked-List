
/* Name: MyLinkedList
 * Authors: Henry Berger and Emmanuel Enabuelele
 * Date:  11-17-17
 * This program creates a generic constructor for LinkedList and a Node. It then incorporates 
 * many methods that can be used on any LinkedList. These methods are then tested in the ListTest.java
 * 
 */


public class MyLinkedList<T> {
    // the Node class is a private inner class used (only) by the LinkedList class
	private class Node<T> {
        private Object data;
        private Node<T> next;
        private T t;
        
        //creates the node constructor
        public Node(Object a, Node<T> n) {
            data = a;
            next = n;
        }
    }
    
	//creates various nodes we will use in methods
    private Node<T> first;
    private Node<T> curr=first;
    private Node<T> tail=null;
    private int length=this.size();  // to enable an O(1) size method
    
    //MyLinkedList constructor
    public MyLinkedList() {
        first = null;
        length = 0;  // added after considering the size() method
    }
    
    //returns true if the list is empty
    public boolean isEmpty() {
        return (first == null);
    }
    
    //adds an object to the front of the list
    public void addFirst(Object d) {
        /* These two lines can be reduced to the single line which follows
         *   Node temp = first;
         *   first = new Node(d,temp);
         */        
        first = new Node<T>(d,first);
        length++;
    }
    
    //returns the size of the list
    public int size() {
     int count = 0;
     for (Node curr = first; curr != null; curr = curr.next)
     count++;
     length=count;
     return count;
     
     //   return length;
    }
    
    //clears all nodes in the list
    public void clear() {
        first = null;
        length = 0;
    }
    
    //returns true if the list has the object in it
    public boolean contains(Object value) {
        for (Node<T> curr = first; curr != null; curr = curr.next) {
            if (value.equals(curr.data)) {
                // this implies that the data must have an overridden .equals() method!
                return true;
            }
        }
        return false;
    }
    
    //returns the object at a specified index
    public Object get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Index of " + index + " out of range");
            return null;
        }
        
        Node<T> curr = first;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr.data;
    }
    
    //removes a certain object from the list
    public boolean remove(Object m) {
        if (isEmpty())
            return false;
        
        if (m.equals(first.data)) {
            first = first.next;
            length--;
            return true;
        }
        
        Node<T> curr = first;
        while (curr.next != null) {
            if (m.equals(curr.next.data)) {
                // this implies that the data must have an overridden equals() method!
                
                curr.next = curr.next.next;
                length--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    
    //converts to string
    public String toString() {
        StringBuilder result = new StringBuilder();  //String result = "";
 
        for (Node<T> curr = first; curr != null; curr = curr.next)
            result.append(curr.data + "->");  //result = result + curr.data + "->";

        result.append("[null]");
        return result.toString();   //return result + "[null]";
    }
    
    // ------------------------  HW4 methods start here ------------------------
    
    //returns the object at the front of the list
    public Object getFirst() {
    	if(first!=null)
    		return first.data;
    	else
    		return null;
    }
    
    //returns the object at the end of the list
    public Object getLast() {
    	if(first != null) {
    		curr = first;
    		
    		//iterates through list until curr is at the last element
    		while (curr.next != null) {
                curr = curr.next;
    		}
    		
    		return curr.data;
    		}
    	else	
        return null;
    }
    
    //adds an object to the list
    public void add(Object value) {
    	
    	if(curr!=null)
        {
    		//sets curr node to a temp node
            Node<T> temp = new Node<T>(value, curr.next);
            curr.next = temp;
            curr = temp;
        }
        else
        {
        	//sets it to the end
            first = tail = new Node<T>(value, null);
            curr = first;
        }
    }
    
    //adds an object after a specified index
    public void addAfter(int index, Object value) {
    	//returns nothing if the index is out of range
    	if (index<0 || index>=length)
    	{
    		System.out.println("Out of range");
    		return;
    	}
    	
    	//iterates through list until the curr node is at the index
    	curr=first;
    	for (int i=0;i<index;i++)
    	{
    		curr=curr.next;
    	}
    	//adds the node after
    	Node newN = curr.next;
    	curr.next = new Node(value, newN);
    	length++;

    }
    
    //sets a specified index to a certain node
    public Object set(int index, Object newValue) {
    	curr = first;
    	if (curr!=null)
    	{
    		//iterates through list until curr is at the specified index
			for (int i = 0; i < index; i++) 
				{
					curr = curr.next;
				}
			Node<T>original = new Node<T>(curr.data,null);
	    	Node<T> temp = curr;
			temp.data = newValue;
	        return original.data;
    	}
    	else
    	{
    		return null;
    	}
    }
    
    //returns the index of the last occurence of a specified object
    public int lastIndex(Object value) {
    int index = 0;
    int last = -1;
    
    	//iterates through list until at the last occurence
        while (index < size()) {
           if (get(index) == value) {
               last = index;
           }
           index ++;
        }
        return last;
    }

    //creates a duplicate of a certain list
    public MyLinkedList<T> clone() {
    	this.size();
    	MyLinkedList<T> clone = new MyLinkedList<T>();
    	curr=first;
    	
    	//adds the curr node of the certain list to a new list
    	for (int i=0;i<length;i++)
    	{
    		clone.add(curr.data);
    		curr=curr.next;
    	}
        return clone;
    }
    
    //removes all occurnces of a specified node
    public void removeAll(Object value) {
     curr = first;
        if (curr == null) {
            return;
        }
        if (first == value) {
            curr = curr.next;
            first = curr.next;
        }           
        
        
        //iterates through list until the next node is the speciified node
        while (curr.next != null) {
            if (curr.next.data == value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    //returns true of an object equals another
    public boolean equals(Object o) {
    	MyLinkedList<Object> list = (MyLinkedList<Object>)o;
    	curr=first;
    	MyLinkedList<Object>.Node<Object>curr2=null;
    	curr2=list.first;
    	if (((MyLinkedList<T>) o).size()!=length)
    		return false;
    	else
    	{
    		//iteraties through until the next node is null(end of the list)
	    	while(curr!=null&&curr2!=null)
	    	{
	    			if (curr.data!=curr2.data)
	    				return false;	
	    			else
	    				curr=curr.next;
	    				curr2=curr2.next;
	    	}
    	}
        return true;
    }
    
    //splits the list into two halves, and returns the second half 
    public MyLinkedList<T> split() {
    	this.size();
    	int middle;
    	int index=0;
    	
    	//sets middle to the middle
    	if (length%2==0)
    	{
    		middle=length/2;
    	}
    	else
    	{
    		middle=length+1;
    		middle=middle/2;
    	}

    	//utilizes sublist to make the new lists
    	MyLinkedList<T>firstHalf =this.sublist(0, middle-1);
    	MyLinkedList<T>secondHalf =this.sublist(middle, length-1);

    	return secondHalf;
        
    }
    
    //adds a second instance of each and every element in a list
    public void doubler() {
    	this.size();
    	curr=first; 
    	//iterates through the list and adds another elemenent for each elements there is
    	for (int i=0;i<length;i++)
    	{
    		if (i%2==0)
    		{
    			this.addAfter(i, curr.data);
    			curr=curr.next;
    		}
    		else
    		{
    			curr=curr.next;
    		}
    	}
    }
    
    //returns a new list from two specified index's
    public MyLinkedList<T> sublist(int i, int j) {
    	MyLinkedList<T> newSublist = new MyLinkedList<T>();
        int 	index = 0;
        curr = first;
        	while(index != i) {
        		curr = curr.next;
        		index++;
        		}
        	while(index >= i && index <= j) {
        		newSublist.add(curr.data);
        		index++;
        		curr = curr.next;
        		
        	}
        	return newSublist;
        	}


    
    public static void main(String[] args) {
      
        
    }
}



