public class HuffmanTree {
    private TreeNode root;
    private TreeNode leftNode;
    private TreeNode rightNode;


    HuffmanTree(TreeNode  left,  TreeNode  right) {
        this.leftNode = left;
        this.rightNode = right;

        HuffmanTree root; // a new root node being assigned
        root = new HuffmanTree(left, right);
    }

    TreeNode getRoot() {
        return root;
    }
}
