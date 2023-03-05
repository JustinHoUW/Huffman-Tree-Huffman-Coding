public class HuffmanTree {
    public TreeNode root;
    public TreeNode leftNode;
    public TreeNode rightNode;

    // Initializes a new Huffman tree
    HuffmanTree(TreeNode  left,  TreeNode  right) {
        this.leftNode = left;
        this.rightNode = right;

        // Creating a new root node and assigning the parameters as the root's left and right children
        root = new TreeNode(null, this.leftNode.priority + this.rightNode.priority);
    }

    // Provides the root node's reference back
    TreeNode getRoot() {
        return this.root;
    }
}
