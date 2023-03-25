package BTExample;

public class MyBT {

    private Node root;
    private int size = 0;

    MyBT(){
        root = null;
    }

    MyBT(int i){
        root = new Node(i);
        tracksize();
    }

    int getRoot(){
        return root.elem;
    }

    // assuming you have the first 3 elements of the binary tree
    MyBT(int i, int y, int w){
        root = new Node(i);
        tracksize();
        if(y < i &&  w > y){
            root.left = new Node(y);
            tracksize();
            root.right = new Node(w);
            tracksize();
            root.left.left=root.left.right=null;
            root.right.left=root.right.right=null;
        }
        else if (y > i &&  w < i){
            root.left = new Node(w);
            tracksize();
            root.right = new Node(y);
            tracksize();
            root.left.left=root.left.right=null;
            root.right.left=root.right.right=null;
        }
    }

    // insert using recursion
    private Node insert_add(Node curr, int i){

        // check if the value is a duplicate
        if(curr==null||size==0){
            curr = new Node(i);
            tracksize();
        }
        else if(i == curr.elem){
            System.out.println("The value already exists in the Tree");
        }

        /*remember the rule which is that the left child node's value must always be
        of a lesser value than it's direct parent so here we check*/
        else if(i < curr.elem){
            curr.left = insert_add(curr.left, i);

        }
        else{
            curr.right = insert_add(curr.right, i);

        }

        return curr;
    }

    void insert(int i){
        Node trav = root;
        trav = insert_add(trav , i);
    }

    // tree traversal method
    private Node traversal(){
        Node trav;
        trav = root;

        // since insertion always starts from the left, traverse the left node
        while(trav != null){
            trav = trav.left;
        }
        return trav;
    }

    // size tracker
    private void tracksize(){
        this.size++;
    }

    // iterates through tree and returns true/false if int is in tree
    boolean search(int i){
        Node temp = root;
        if(root.elem == i) {
            return true;
        }
        for(int j = 0; i < size; j++){
            if(i < temp.elem){
                if(temp.left.elem == i){
                    return true;
                }
                temp = temp.left;
            }else{
                if(temp.right.elem == i){
                    return true;
                }
                temp = temp.right;
            }
        }
        return false;
    }

    // recursively traverses trough tree until it finds the node to be deleted, replaces node depending on if it has 2 childs or not
    void delete(int i){
        root = deleteHelper(root, i);
    }

    Node deleteHelper(Node root, int elem) {
        if (root == null) {
            return root;
        }
        if (elem < root.elem) {
            root.left = deleteHelper(root.left, elem);
        } else if (elem > root.elem) {
            root.right = deleteHelper(root.right, elem);
        } else { // node has 1 or 0 childs
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
        }
        // if 2 childs, takes smallest from the right branch of the root
        root.elem = smallest(root.right);
        root.right = deleteHelper(root.right, root.elem);
        return root;
    }

    int smallest(Node root)
    {
        int small = root.elem;
        while (root.left != null) {
            small = root.left.elem;
            root = root.left;
        }
        return small;
    }

    void printBT(){
        Node trav;
        trav = root;
        inorderprint(trav);

    }

    void printBT(String s){
        Node trav;
        trav = root;
        if(s.equalsIgnoreCase("pre")) {
            preorderprint(trav);
        }
        else if (s.equalsIgnoreCase("post")) {
            postorderprint(trav);
        }
    }

    void inorderprint(Node n) {
        if(n != null){
            inorderprint(n.left);
            System.out.println(n.elem);
            inorderprint(n.right);
        }
    }

    void preorderprint(Node n) {
        if(n != null){
            System.out.println(n.elem);
            preorderprint(n.left);
            preorderprint(n.right);
        }
    }


    void postorderprint(Node n) {
        if(n != null){
            postorderprint(n.left);
            postorderprint(n.right);
            System.out.println(n.elem);

        }
    }

    int size(){
        return this.size;
    }

}