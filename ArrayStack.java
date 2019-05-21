import java.util.Arrays;

/**
 * An array implementation of a stack in which the bottom of the
 * stack is fixed at index 0.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayStack<T> implements StackADT<T>
{
    private final static int DEFAULT_CAPACITY = 2;
    private final static int EMPTY = -1;

    private int top;
    private T[] stack;
    private int size;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty stack using the specified capacity.
     * @param initialCapacity the initial size of the array
     */
    public ArrayStack(int initialCapacity)
    {
        size=0;
        top = EMPTY; // Stack is empty
        stack = (T[])(new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary.
     * @param element generic element to be pushed onto stack
     */
    public void push(T element)
    {
        top++; // Increment to next available spot
        if (size() == stack.length)
            expandCapacity();

        stack[top] = element;
        size++; //Increment size
    }

    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        T result = stack[top];
        stack[top] = null;
        top--;
        size--;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack[top];
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     * @return true if this stack is empty
     */
    public boolean isEmpty()
    {
        return (size == 0);  // temp
    }

    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        return size;  // temp
    }

    /**
     * Returns a string representation of this stack.
     * @return a string representation of the stack
     */
    public String toString()
    {
        String s="";
        for(int i=0;i<size;i++){
            s= s+stack[i]+"\n";
        }
        return s;
    }
}