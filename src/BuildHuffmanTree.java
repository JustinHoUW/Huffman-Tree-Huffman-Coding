import java.util.HashMap;
import java.util.Map;

public class BuildHuffmanTree extends Queue {
    private static HuffmanTree htree;
    private static TreeNode ltreeNode;
    private static TreeNode rtreeNode;
    private static TreeNode node;

    // utilizes a Queue to construct and deliver the root node of the finished HuffmanTree.
    static TreeNode buildTreeQueue(HashMap<Character, Integer>
                                           freqTbl, Queue<TreeNode> q) throws Exception {


        node = new TreeNode(null, 0);
        ltreeNode = new TreeNode(null, 0);
        rtreeNode = new TreeNode(null, 0);
        htree = new HuffmanTree(ltreeNode, rtreeNode);

        // iterate through the Hash table and add it to the queue
        // each element in the returned set is a Map entry
        for (Map.Entry<Character, Integer> entry : freqTbl.entrySet()) {
            // Follow constructor of TreeNode class
            q.enqueue(new TreeNode(entry.getKey(), entry.getValue()));
        }
        // Initialize priority of new HuffmanTree root
        htree.root.priority = 0;

        while (q.count > 1) {
            // Initialize New node
            node = new TreeNode(null, 0);

            // GET Left Child Priority Value (dequeue) and Right Child Priority Value (dequeue)
            node.left = q.dequeue();

            node.right = q.dequeue();

            // Initialize New Huffman Tree
            htree = new HuffmanTree(node.left, node.right);

            // Add up the priority values of BOTH Left child and Right child
            // and add that to Root Priority
            htree.root.priority = node.left.priority + node.right.priority;

            // Add root to queue once Huffman tree has left and right child priority
            q.enqueue(htree.root);
        }

        // Returns the root node of the final HuffmanTree
        return htree.root;
    }

    // utilizes a PriorityQueue to construct and deliver the root node of the finished HuffmanTree.
    static TreeNode buildTreePQ(HashMap<Character, Integer>
                                        freqTbl, PriorityQueue<TreeNode> pq) throws Exception {

        node = new TreeNode(null, 0);
        ltreeNode = new TreeNode(null, 0);
        rtreeNode = new TreeNode(null, 0);
        htree = new HuffmanTree(ltreeNode, rtreeNode);

        // iterate through the Hash table and add it to the Priority Queue
        // each element in the returned set is a Map entry
        for (Map.Entry<Character, Integer> entry : freqTbl.entrySet()) {
            // Follow constructor of TreeNode class
            pq.insert(new TreeNode(entry.getKey(), entry.getValue()));
        }
        // Initialize priority of new HuffmanTree root
        htree.root.priority = 0;

        while (pq.count > 1) {
            // Initialize New node
            node = new TreeNode(null, 0);

            // GET Left Child Priority Value (dequeue) and Right Child Priority Value (dequeue)
            node.left = pq.remove();

            node.right = pq.remove();

            // Initialize New Huffman Tree
            htree = new HuffmanTree(node.left, node.right);

            // Add up the priority values of BOTH Left child and Right child
            // and add that to Root Priority
            htree.root.priority = node.left.priority + node.right.priority;

            // Add root to queue once Huffman tree has left and right child priority
            pq.insert(htree.root);
        }

        // Returns the root node of the final HuffmanTree
        return htree.root;

    }

    static void encodeTraversal(TreeNode root, String code,
                                HashMap<Character, String> encodTbl) {

        // If element of root isn't node
        if (root.elem != null) {
            // Store the element in the HashMap
            // Along with the Code assigned
            encodTbl.put(root.elem, code);

        } else {
            // If we go to left then add "0" to the code.
            encodeTraversal(root.left, code + "0", encodTbl);

            // If we go to the right add "1" to the code.
            encodeTraversal(root.right, code + "1", encodTbl);

        }

    }
}





