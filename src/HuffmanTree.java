public class HuffmanTree {
    TreeNode root;

    // creates a new root node for the Huffman Tree
    // adds the parameters as the root's left and right children.
    HuffmanTree(TreeNode  left,  TreeNode  right) {
        root = new TreeNode(null, 0);
        root.left = left;
        root.right = right;
    }

    // Provides the root node's reference back
    TreeNode getRoot() {
        return this.root;
    }
}
