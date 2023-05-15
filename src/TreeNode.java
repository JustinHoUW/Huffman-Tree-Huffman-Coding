public class TreeNode implements Comparable<TreeNode> {
    // Each node contains left and right child
    TreeNode left;
    TreeNode right;
    int priority;
    Character elem;

    // the TreeNode is created with the specified priority value.
    TreeNode(int priority) {
        this.priority = priority;
        priority = 0;

    }

    // the TreeNode is initialized with the specified elem and priority values.
    public TreeNode(Character elem, int priority) {
        this.elem = elem;
        this.priority = priority;
    }


    // Implement compareTo
    // Compare current node priority value with given node priority value in parameter
    @Override
    public int compareTo(TreeNode n) {
        if (this.priority > n.priority) {
            return 1;
        }
        else if (this.priority < n.priority) {
            return -1;
        }
        else {
            // If priority values equal return 0
            return 0;
        }
    }

    public TreeNode getleft() {
        return left;
    }

    public TreeNode getright() {
        return right;
    }

    public void setLeft(TreeNode left)
    {
        this.left = left;
    }

    public void setRight(TreeNode right)
    {
        this.right = right;
    }



}
