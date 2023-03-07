public class PriorityQueue<T extends Comparable<T>> extends ArrayHeap<T> {

    ArrayHeap pq;
    int count = 0;
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 30;


    //Initializes a priority queue of default size{
    public PriorityQueue() {
        pq = new ArrayHeap(DEFAULT_CAPACITY);
    }

    // Initializes a priority queue based on capacity parameter
    PriorityQueue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity cannot be less than or equal to 0");
        pq = new ArrayHeap(capacity);
    }

    // Adds the parameter elem to the PriorityQueue
    void insert(T elem) throws Exception {
        pq.addElement(elem);
        count++;
    }

    // Removes  and  returns  the  element  with  highest  priority
    T remove() throws Exception {
        T temp = (T) pq.removeMin();
        count--;
        return temp;
    }

    @Override
    public String toString() {
        String myString = "["; // Add onto myString variable and return after iterating through loop
        int curr = 1; // To start at index of root

        // If the Priority Queue is empty, then it should return exception
        if (count == 0) {
            return "PriorityQueue is empty";
        } else {
            for (int i = 0; i <= count - 1; i++) {
                // If i equals last possible index
                if (i == count - 1) {
                    // End off with brackets to follow format
                    myString += pq.heap[curr] + "]";
                } else {
                    myString += pq.heap[curr] + ", ";
                    curr++;
                }
            }
        }
        return myString;
    }

}




