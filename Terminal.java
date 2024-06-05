public class Terminal{
    public static void main(String[] args){
        TreeMethods method = new TreeMethods();
        TreeNode tree = new TreeNode(40);
        method.add(30, tree);
        method.add(25, tree);
        method.add(15, tree);
        method.add(28, tree);
        method.add(35, tree);
        method.add(50, tree);
        method.add(45, tree);
        method.add(60, tree);
        method.add(55, tree);
        method.add(70, tree);
        method.preOrder(tree);
        System.out.println(method.search(tree, 45));
        method.remove(tree, 45);
        method.preOrder(tree);
    }
}
// pre order 40 30 25 15 28 35 50 45 60 55 70
// in order 15 25 28 30 35 40 45 50 55 60 70
// post order 15 28 25 35 30 55 70 60 45 50 40  