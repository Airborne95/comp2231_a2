/**
 * Represents a linked implementation of a stack.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedStack<T> implements StackADT<T>
{
    private int count;
    private int capacity;
    private LinearNode<T> bottom;
    private LinearNode<T> top;
    private final static int DEFAULT_CAPACITY = 50;


    /**
     * Creates an empty stack.
     */
    public LinkedStack()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty stack.
     */
    public LinkedStack(int capacity)
    {
        count = 0;
        this.capacity = capacity;
        top = bottom =null;

    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    public void push(T element)
    {
        if(isFull()){
            dropBottomElement();
        }
        LinearNode<T> temp = new LinearNode<T>(element);

        temp.setNext(top);
        top = temp;
        if(isEmpty()){
            bottom=temp;
        }
        count++;
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        T result = top.getElement();
        top = top.getNext();
        count--;
        if(isEmpty()){
            bottom=null;
        }

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if(isEmpty())
            throw new EmptyCollectionException("stack");
        return top.getElement();  // temp
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     * @return true if stack is empty
     */
    public boolean isEmpty()
    {
        return (count==0);  // temp
    }

    /**
     * Returns the number of elements in this stack.
     * @return number of elements in the stack
     */
    public int size()
    {
        return count;  // temp
    }

    /**
     * Returns a string representation of this stack.
     * @return string representation of the stack
     */
    public String toString()
    {
        // To be completed as a Programming Project
        String s ="Stack: \n";
        LinearNode temp = top;
        while(temp != null){
            s=s+temp.getElement() + "\n";
            temp = temp.getNext();
        }
        return s;
    }

    /**
     * Returns true if this stack is full and false otherwise.
     * @return true if stack is full
     */
    public boolean isFull()
    {
        return (count==capacity);  // temp
    }

    /**
     * Removes the last element at the bottom of this stack.
     */
    public void dropBottomElement()
    {
        LinearNode<T> temp = top;
        while(temp.getNext()!=bottom){
            temp=temp.getNext();
        }
        bottom = temp;
        bottom.setNext(null);
        count--;
    }
}
