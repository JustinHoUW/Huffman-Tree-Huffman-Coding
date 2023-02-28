// SLL class from Assignment 1B
public class SLL<T> {
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

    boolean isEmpty() {
        if (front == null) {
            return true;
        } else {
            return false;
        }
    }

    // addFront method
    // Time Complexity : O(1)
    void addFront(T elem) {
        Node temp = new Node(elem);
        if (isEmpty()) {
            temp.next = front;
            front = rear = temp; // Update position of front and rear
        } else { // If list isn't empty
            temp.next = front;
            front = temp;
        }
        count++; // Increment count
    } // End Method

    // addRear method
    // Time Complexity : O(1)
    void addRear(T elem) {
        Node temp = new Node(elem);
        rear.next = null;
        if (isEmpty()) {
            front = rear = temp; // front and rear node point to the SAME Position
        } else {
            rear.next = temp;
            rear = temp; // Update position of rear
        }
        count++; // Increment count
    } // End Method

    // add method
    // Time Complexity: O(n)
    void add(int index, T elem) {
        if (isEmpty()) {
            addFront(elem);
        }
        // If the Index equals the length of the linked list, the node will be appended at  the
        // end of the list.
        else if (index == count) {
            addRear(elem);
            count++;
        } else if (index < 0 || index > count) { // Index is not within the valid range
            throw new IllegalArgumentException("index is not within the valid range");
        } else {
            Node temp = new Node(elem);
            Node curr = front; // Dummy pointer for front
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            } // End method
            temp.next = curr.next;
            curr.next = temp; // de-link and attach temp to linked list
            count++; // Increment count
        }

    } // End Class

    // Delete method
    // Time Complexity: O(n)
    T delete(int index) {
        Node curr = front, prev = null;
        if (index < 0 || index > count) { // Index is not within the valid range
            throw new IllegalArgumentException("index is not within the valid range");
        }
        if (index == 0) {
            T result = front.elem;
            front = front.next;
            return result;
        }
        // If index is viable or in range
        else {
            for (int i = 0; i < index; i++) {
                prev = curr; // dummy for curr
                curr = curr.next; // Increment through loop

            }
            prev.next = curr.next; // Detach current node since it's going to be deleted
            count--; // Decrement count after deleted node
        }
        return curr.elem; // return the value of the node
    }

    // get Method
    // Time Complexity: O(n)
    T get(int index) {
        Node curr = front;
        T element = curr.elem; // Variable used to return type T
        if (index < 0 || index > count) { // Index is not within the valid range
            throw new IllegalArgumentException("index is not within the valid range");
        } else { // Index is in viable range
            for (int i = 0; i < count; i++) {
                if (i == index) {
                    element = curr.elem; // value of the node at index
                    break;
                }
                curr = curr.next;
            }
            return element; // Return value of the node
        }
    }

    // swap method
    // Time Complexity: O(n)
    // Pre-condition: index1 <= index2
    void swap(int index1, int index2) {
        if (index1 < 0 || index1 > count || index2 < 0 || index2 > count || index1 > index2) { // Index is not within the valid range
            throw new IllegalArgumentException("index is not within the valid range");
        } else if (index1 == index2) { // If both index equals, no point of swap
            return;
        } else if (count == 0) { // List is empty
            return;
        } else {
            Node curr1 = front, prev1 = null;
            Node curr2 = front, prev2 = null;

            // If variable index1 not equal to 0, traverse through list to get prev (PREVIOUS node to Curr)
            // and curr node at index1
            if (index1 != 0) {
                for (int i = 0; i < index1; i++) {
                    prev1 = curr1;
                    curr1 = curr1.next; // curr1 is at index1 (index position) as loop end
                }
            }
            // If variable index2 not equal to 0, traverse through list to get prev (PREVIOUS node to Curr)
            // and curr node at index2
            if (index2 != 0) {
                for (int i = 0; i < index2; i++) {
                    prev2 = curr2;
                    curr2 = curr2.next; // curr2 is at index2 (index position) as loop end
                }
            }
            // If CURRENT node of index1 are null
            // OR prev_.next = null POINT front node = current node at index
            if (prev2 == null || curr1 == null) {
                front = curr1;
            }
            // Link the opposing previous, so prev2 next will be linked with curr1... vice versa
            // De-links and attach prev_.next with the opposing node (SWAP)
            else {
                prev2.next = curr1;
            }
            // If CURRENT node of index2 are null
            // OR prev_.next = null POINT front node = current node at index
            if (prev1 == null || curr2 == null) {
                front = curr2;
            }
            // Link the opposing previous, so prev1 next will be linked with curr2... vice versa
            // De-links and attach prev_.next with the opposing node (SWAP)
            else {
                prev1.next = curr2;
            }

            // Use dummy pointer to not LOSE TRACK of curr1 node
            // exchanges the next pointer of curr1 and curr2 node
            Node dummy = curr1.next;
            curr1.next = curr2.next;
            curr2.next = dummy;

        }
    }

    // Format [elem1, elem2, elem3,...]
    @Override
    public String toString() {
        Node curr = front;
        String myString = "";
        // Variable myString to form the format [elem1, elem2, elem3,...] after few statements
        myString += "[";
        // Increment through the loop
        for (int i = 0; i < count; i++) {
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