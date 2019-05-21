/**
 * Used to test the ShellArray class
 *
 * @author Mohammad Chaudhry
 * @version 1.0
 * 2019.01.25
 * T00554758
 */

import java.util.Scanner;

public class Driver{
    public static void main(String[] args){
        //arrayStackTest();
        //dropOutStackTest();
        //deque();
        palindromeTest();
    }

    public static void arrayStackTest(){
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        arrayStack.push(7);
        arrayStack.push(10);
        arrayStack.push(4);
        System.out.print(arrayStack.toString());
    }

    public static void dropOutStackTest(){

        LinkedStack<Integer> linkedStack = new LinkedStack<Integer>(3);

        linkedStack.push(10);
        linkedStack.push(11);
        linkedStack.push(12);
        System.out.println(linkedStack.toString());

        linkedStack.push(13);
        System.out.println(linkedStack.toString());
    }

    public static void deque(){
        CircularArrayQueue<Integer> deque = new CircularArrayQueue<Integer>();
        deque.enqueueFront(11);
        deque.enqueueFront(10);
        deque.enqueueFront(9);
        System.out.println(deque.toString());
        // Expected Result: 'Queue: 9, 10, 11'
        deque.enqueue(12);
        System.out.println(deque.toString());
        // Expected Result: 'Queue: 9, 10, 11, 12'

        deque.dequeue();
        System.out.println(deque.toString());
        // Expected Result: 'Queue: 10, 11, 12'

        deque.dequeueRear();
        System.out.println(deque.toString());
        // Expected Result: 'Queue: 10, 11'
    }

    public static void palindromeTest(){
        LinkedStack <String> wordStack = new LinkedStack<String>();
        LinkedQueue <String> wordQueue = new LinkedQueue<String>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a word to check if its a palindrome...");
        String input = scan.nextLine();
        System.out.printf("Checking if '%s' is a palindrome\n", input);

        // Initialize Queue and Stack
        for (int i = 0; i < input.length(); i++) {
            wordStack.push(String.valueOf(input.toLowerCase().charAt(i)));
            wordQueue.enqueue(String.valueOf(input.toLowerCase().charAt(i)));
        }

        while (!wordQueue.isEmpty() && !wordStack.isEmpty() && wordQueue.first().equals(wordStack.peek())) {
            wordQueue.dequeue();
            wordStack.pop();
        }

        if (wordQueue.isEmpty() && wordStack.isEmpty()) {
            System.out.printf("'%s' is a palindrome!\n", input);
        } else {
            System.out.printf("'%s' is not a palindrome =( \n", input);
        }
    }
}