public class TreeNode {
    protected int data;
    protected TreeNode right;
    protected TreeNode left;
    protected TreeNode previous;

    public TreeNode(int data){
       this.data = data;
       this.right = null;
       this.left = null;
       this.previous = null;
    }
    public TreeNode(int data, TreeNode previous){
        this.data = data;
        this.right = null;
        this.left = null;
        this.previous = previous;
    }
    public TreeNode(int data, TreeNode left, TreeNode previous){
        this.data = data;
        this.right = null;
        this.left = left;
        this.previous = previous;
    }
    public TreeNode(int data, TreeNode left, TreeNode right, TreeNode previous){
        this.data = data;
        this.right = right;
        this.left = left;
        this.previous = previous;
    }
    public getData(){return data;}
}
