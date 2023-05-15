public class ArrayHeap<T extends Comparable<T>> {

    // Initializes a heap of default size 10
    T[] heap;
    int count = 0;
    // variable used in compareTo() method
    int useCompareCurr = 0;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 30;

    ArrayHeap() {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    // Initializes a heap based on capacity parameter
    ArrayHeap(int capacity) {
        capacity = 30;
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity cannot be less than or equal to 0");
        heap = (T[]) new Comparable[capacity];

    }

    //check for OVERFLOW since using Array for Heap
    boolean isFull() {
        if (count == DEFAULT_CAPACITY - 1) {
            return true;
        }
        return false;
    }

    public int getCount() {
        return count;
    }

    public void count(int count)
    {
        this.count = count;
    }

    // check for UNDERFLOW since using Array for Heap
    boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }


    // Efficient swapping of Array Elements
    void swap(T[] heap, int curr, int par) {
        T t = heap[curr];
        heap[curr] = heap[par];
        heap[par] = t;

    }

    // Adds a new element in the heap
    // Time Complexity: O(log n)
    void addElement(T obj) throws Exception {
        if (isFull()) {
            // Resize Array
            Object[] largerArray = new Object[DEFAULT_CAPACITY * 2];
            System.arraycopy(heap, 0, largerArray, 0, heap.length);
        }
        // If array isn't full
        else {
            // Current index of element
            int curr = count + 1;
            useCompareCurr = curr;

            // Parent index of element
            int par = curr / 2;

            // Add element in ArrayHeap
            heap[curr] = obj;

            // HEAPIFY
            // Parent of current node
            // is index of current node in the array divided by 2
            T parent = heap[curr / 2];

            // If current element is LESS than its parent
            // Swap the positions of the two nodes to maintain minHeap property
            // Use compareTo, returns POSITIVE value if larger than other, NEGATIVE if less, and 0 if EQUALS
            while (parent != null && heap[useCompareCurr] != null && heap[useCompareCurr / 2] != null && curr > 0 &&
                    heap[useCompareCurr].compareTo(heap[par]) <= -1) {
                swap(heap, useCompareCurr, par);
                // Update curr index
                useCompareCurr = useCompareCurr / 2;
                // Update parent index
                par = useCompareCurr / 2;
            }  // End heapify
        }// End method
        useCompareCurr = 0;
        count++; // Increment count
    }

    // Removes  and  returns  the  element  with  the  lowest  value
    // Time Complexity O(log n)
    T removeMin() throws Exception {
        // Get root of Heap and apply to variable result
        T result = heap[1];
        if (isEmpty()) {
            throw new Exception("Can't remove minimum element from Empty ArrayHeap");
        } else {
            int curr = 1;
            useCompareCurr = curr;

            // To maintain completeness of tree, replace root node with last leaf in minHeap
            int rootIndex = 1;
            int lastIndex = count;
            swap(heap, rootIndex, lastIndex);
            heap[lastIndex] = null; // Delete element
            count--; // Decrement count

            //HEAPIFY
            int leftChild = curr * 2, rightChild = curr * 2 + 1;
            // Use compareTo, returns POSITIVE value if larger than other, NEGATIVE if less, and 0 if EQUALS

            outerloop:
            while (count >= 1 ) {
                // Signifies leaf node OR Heapify isn't needed

                if (heap[leftChild] == null || (heap[useCompareCurr].compareTo(heap[leftChild]) <= 0)) {
                    break; // No need to swap since leaf node FORCE BREAK
                } else {
                    while (heap[useCompareCurr].compareTo(heap[leftChild]) >= 1
                            || heap[useCompareCurr].compareTo(heap[rightChild]) >= 1) {
                        if (heap[rightChild] == null && heap[useCompareCurr].compareTo(heap[leftChild]) >= 1) {
                            // if right child already null and left child greater than parent
                            // Swap with left child then break out out the loop
                            swap(heap, curr, leftChild);
                            break outerloop; // Break loop after swapping with left child
                        }
                        // While current node is greater than its childs AND
                        // IF Right child is greater than its Left child
                        if (heap[rightChild].compareTo(heap[leftChild]) >= 0) {
                            // swap curr with the child that has the least element out of the two (Left Child)
                            swap(heap, curr, leftChild);
                            // Curr is now on left child index since we swapped curr with left child
                            useCompareCurr = curr * 2;
                            // UPDATE left child
                            leftChild = useCompareCurr * 2;

                            // UPDATE right child
                            rightChild = useCompareCurr * 2 + 1;

                            // Now that swapped with left child, UPDATE curr
                            curr = curr * 2;

                            // break if left child greater or equal than count
                            // Can't heapify anymore
                            if (leftChild >= count) {
                                break outerloop;
                            }
                        } else {
                            // swap curr with the child that has the least element out of the two (Right Child)
                            swap(heap, curr, rightChild);
                            // Curr is now on Right child index since we swapped curr with right child
                            useCompareCurr = curr * 2 + 1;

                            // UPDATE left child
                            leftChild = useCompareCurr * 2;
                            // UPDATE right child
                            rightChild = useCompareCurr * 2 + 1;

                            // Now that swapped with Right child, UPDATE curr
                            curr = curr * 2 + 1;

                            // break if left child greater or equal than count
                            // Can't heapify anymore
                            if (leftChild >= count) {
                                break outerloop;
                            }
                        }
                    }
                }// End
            }

        }
        return result; // Return element with lowest value
    }


    // [elem1, elem2, elem3...]
    // Contents of the ArrayHeap are displayed in a level-order traversal
    @Override
    public String toString() {
        String myString = "["; // Add onto myString variable and return after iterating through loop
        int curr = 1; // To start at index of root

        // If the heap is empty, then it should return []
        if (isEmpty()) {
            return "[]";
        } else {
            // Iterate through array
            for (int i = 0; i <= count - 1; i++) {
                // If i equals last possible index
                if (i == count - 1) {
                    // End off with brackets to follow format
                    myString += heap[curr] + "]";
                } else {
                    myString += heap[curr] + ", ";
                    curr++;
                }
            }
        }
        return myString;
    }
}
