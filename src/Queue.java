// Queue class from Assignment 1B
public class Queue<T> extends SLL {
    Node front = null, rear = null;
    int count = 0;

    public class Node { // Node class will Reside within SLL Class as an Inner Class
        // Part I: Design & Implement the Node<T> Class
        T elem;
        Node next = null;

        public Node(T val) {
            elem = val;
        }
    }

    // initializes the Queue object
    Queue() {
        SLL linkedList = new SLL();
    }


    // Check for Underflow
    boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    // Adds elem parameter at the end of the queue
    // Time Complexity O(1)
    void enqueue(T elem) {
        Node temp = new Node(elem);
        // check underflow
        // If queue is empty point front and rear pointer to temp (Same Index)
        if (isEmpty()) {
            front = rear = temp;
            count++;
        }
        // Queue is not empty
        else {
            rear.next = temp; // Add elem from parameter to end of queue
            rear = temp;
            count++;
        }
    }

    // delete and return the element at  the front of the queue
    // Time Complexity O(1)
    T dequeue() throws Exception {
        // check underflow
        if (isEmpty()) {
            throw new Exception("Can't delete from an Empty Queue");
        } else {
            T result = front.elem; // Variable result used to return

            // If ONLY 1 element in the queue
            // set result to element of front node
            // set rear to point to the only node (front)
            if (count == 1) {
                result = front.elem;
                rear = front;
                count--;
            }
            // IF More than one node
            else {
                result = front.elem;
                front = front.next;
                count--;
            }
            return result;

        }
    }

    // return  the  element  at  the  front  of  the  queue
    // Time Complexity O(1)
    T peek() throws Exception {
        T result; // Variable result used to return
        // Check for underflow
        if (isEmpty()) {
            throw new Exception("Can't peek from an Empty Queue");
        } else {
            result = front.elem; // Result variable points to front
        }
        return result;
    }

    // Format [elem1, elem2, elem3,...]
    @Override
    public String toString() {
        Node curr = front;
        String myString = "";
        // If the queue is empty, then it should return “Queue is empty”.
        if (isEmpty()) {
            return "Queue is empty";
        }
        // Variable myString to form the format [elem1, elem2, elem3,...] after few statements
        myString += "[";
        // Increment through the loop
        for (int i = 0; i < count; i++) {
            // If i equals to last valid index
            // Close off with bracket to follow the FORMAT
            if (i == count - 1) {
                myString += curr.elem;
                myString += "]";
                break;
            }
            myString += curr.elem + ", ";
            curr = curr.next;
        }
        return myString;
    }

}