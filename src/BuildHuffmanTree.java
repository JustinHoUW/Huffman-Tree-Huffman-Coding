import java.util.HashMap;
import java.util.Map;

public class BuildHuffmanTree extends Queue {


    // utilizes a Queue to construct and deliver the root node of the finished HuffmanTree.
    static TreeNode buildTreeQueue(HashMap<Character, Integer>
                                           freqTbl, Queue<TreeNode> q) throws Exception {
        /*
        // Loop over the input text's characters
        // Every character either adds a new entry to the map for it OR increases the priority value
        for (char character: text.toCharArray()) {
        Integer entry = freqTbl.get(character); // Make new entry in the map with Integer value
            treeNode.priority = entry;


            // insert in the HashMap a specific key and the value
        // If key already EXISTS, increment int value, if NOT value doesn't change
            if (entry != null) {
                freqTbl.put(character, entry + 1);
            }
            else {
                freqTbl.put(character, 1);
            }

            for (int i = 0; i < freqTbl.size(); i++) {
                q.enqueue();
            }

        }
         */

        // iterate through the Hash table and add it to the queue
        // each element in the returned set is a Map entry
        for (Map.Entry<Character, Integer> entry : freqTbl.entrySet()) {
            // Follow constructor of TreeNode class
            q.enqueue(new TreeNode(entry.getKey(), entry.getValue()));
        }

        // create a new Huffman tree
        HuffmanTree htree = null;


        while (q.count > 1) {
            // With the root priority
            // FROM the left child priority (dequeue) and the right child priority (dequeue)
            htree.leftNode = q.dequeue();
            htree.rightNode = q.dequeue();

            // Add to queue once new Huffman tree has left and right child priority
            q.enqueue(htree.root);
        }

        // Returns the root node of the final HuffmanTree
        return htree.root;
    }

    //Utilizes a PriorityQueue to construct and deliver the root node of the finished HuffmanTree.
    static  TreeNode  buildTreePQ  (HashMap<Character,  Integer>
                                            freqTbl, PriorityQueue<TreeNode> pq) {

    }


}


