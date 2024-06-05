import java.util.ArrayList;
public class TreeMethods{
    public void add(int data, TreeNode start){
        TreeNode current = start;
        boolean running = true;
        while (running){
            if (current.data > data){
                if (current.left == null){
                    current.left = new TreeNode(data, current);
                    running = false;
                }
                else{
                    current = current.left;
                }
            }
            else if (current.data < data){
                if (current.right == null){
                    current.right = new TreeNode(data, current);
                    running = false;
                }
                else{
                    current = current.right;
                }
            }
            else{
                System.out.println("no duplicate values");
                running = false;
            }
        }
    }
    public void add(TreeNode start, ArrayList<Integer> stuff){
        for (int i = 0; i < stuff.size(); i++){
            add(stuff.get(i), start);
        }
    }
    public void preOrder(TreeNode start){
        TreeNode initialValue = start; 
        TreeNode current = start;
        boolean running = true;
        boolean previous = false;
        ArrayList<Integer> heldValues = new ArrayList<Integer>();
        while (running){
            if (!previous){
                System.out.print(current.data + " ");
                heldValues.add(current.data);
            }
            if (current.left != null && heldValues.contains(current.left.data) == false){
                current = current.left;
                previous = false;
            }
            else if (current.right != null && heldValues.contains(current.right.data) == false){
                current = current.right;
                previous = false;
            }
            else{
                current = current.previous;
                previous = true;
            }
            if (current == initialValue){
                if (current.left == null || heldValues.contains(current.left.data)){
                    if (current.right == null || heldValues.contains(current.right.data)){
                        running = false;
                    }
                }
            }

        }
        System.out.println("");
    }
    public void inOrder(TreeNode start){ // make it so it stops when it gets back to itself
        TreeNode current = start;
        boolean running = true;
        ArrayList<Integer> heldValues = new ArrayList<Integer>();
        while (running){
            if (!heldValues.contains(current.data) && (current.left == null || heldValues.contains(current.left.data))){
                System.out.print(current.data + " ");
                heldValues.add(current.data);
            }
            else if (current.left != null && !heldValues.contains(current.left.data)){
                current = current.left;  
            }
            else if (heldValues.contains(current.data) && current.right != null && !heldValues.contains(current.right.data)){
                current = current.right;
            }
            else{
                if (current.previous == null && (current.right == null || heldValues.contains(current.right.data))){
                    running = false;
                }
                else{
                    current = current.previous;
                }
            }
        }
        System.out.println("");
    }

    public void postOrder(TreeNode start){ //same thing as above think it still works
        TreeNode current = start;
        boolean running = true;
        ArrayList<Integer> heldValues = new ArrayList<Integer>();
        while(running){
            if ((current.left == null || heldValues.contains(current.left.data)) && (current.right == null || heldValues.contains(current.right.data)) && !heldValues.contains(current.data)){
                System.out.print(current.data + " ");
                heldValues.add(current.data);
            }
            else if (current.left != null && !heldValues.contains(current.left.data)){
                current = current.left;
            }
            else if (current.right != null && !heldValues.contains(current.right.data)){
                current = current.right;
            }
            else{
                if (current.previous == null && (current.right == null || heldValues.contains(current.right.data))){
                    running = false;
                }
                else{
                    current = current.previous;
                }
            }
        }
        System.out.println("");
    }
    public boolean search(TreeNode start, int item){
        TreeNode current = start;
        boolean running = true;
        ArrayList<Integer> heldValues = new ArrayList<Integer>();
        while(running){
            if (item == current.data){
                return true;
            }
            else{
                if (item > current.data && current.right != null){
                    current = current.right;
                }
                else if (item < current.data && current.left != null){
                    current = current.left;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    public void remove(TreeNode start, int item){
        TreeNode current = start;
        boolean running = true;
        boolean failed = false;
        TreeNode initialValue = start; 
        boolean previous = false;
        ArrayList<Integer> heldValues = new ArrayList<Integer>();
        while (running){
            if (!previous){
                heldValues.add(current.data);
            }
            if (current.left != null && heldValues.contains(current.left.data) == false){
                current = current.left;
                previous = false;
            }
            else if (current.right != null && heldValues.contains(current.right.data) == false){
                current = current.right;
                previous = false;
            }
            else{
                current = current.previous;
                previous = true;
            }
            if (current == initialValue){
                if (current.left == null || heldValues.contains(current.left.data)){
                    if (current.right == null || heldValues.contains(current.right.data)){
                        running = false;
                    }
                }
            }

        }
        if (heldValues.contains(item)){
            heldValues.remove(heldValues.indexOf(item));
        }
        else{
            failed = true;
        }
        if (failed){
            System.out.println("not in the tree");
        }
        else{
            start.left = null;
            start.right = null;
            start.data = heldValues.get(0);
            heldValues.remove(0);
            TreeMethods method = new TreeMethods();
            method.add(start, heldValues);
        }
    }
}
