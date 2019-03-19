
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */


import java.util.NoSuchElementException;

public class Queue<T> {
	private QueueElement<T> head;
	private QueueElement<T> tail;
	private int count = 0;
	
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    this.head = null;
	    this.tail = null;
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
	    return ((head ==null) && (tail == null));
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		if (head != null){
		    return head.getElement();
        }else{
		    throw new NoSuchElementException();
        }
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            this.head = this.head.getNext();
            if (head == null) {
                tail = null;
            }count--;
        }
    }
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
        QueueElement<T> newNode = new QueueElement<>(element,null);
	    if(this.tail == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.setNext(newNode);
            tail = newNode;
        }count++;
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
	    if (head != null) {
            QueueElement<T> curItem = head;
            for (int index = 0; index < count; index++) {
                System.out.print(curItem.getElement());
                System.out.println();
                curItem = curItem.getNext();
            }
            System.out.println();
        }
	}
}
