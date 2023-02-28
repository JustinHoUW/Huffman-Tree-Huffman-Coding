public class TreeNode implements Comparable<TreeNode> {
    Object TreeNode;
    int priority;

    // the TreeNode is created with the specified priority value.
    TreeNode(int priority) {
        this.priority = priority;
        priority = 0;

        TreeNode = new TreeNode(priority);
    }

    // the TreeNode is initialized with the specified elem and priority values.
    public TreeNode(Character elem, int priority) {
        this.priority = priority;
        TreeNode = new TreeNode(elem, priority);
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
            return 0;
        }
    }



}
