package BTExample;

public class MainBTTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //MyBT daT = new MyBT(2,5,1);
        MyBT daT = new MyBT(2);
        daT.insert(4);
        daT.insert(3);

        System.out.println("The tree has " + daT.size() + " elements.");
        System.out.println("Here are the elements in the Binary Tree in-order.");
        daT.printBT();
        System.out.println("Here are the elements in the Binary Tree pre-order.");
        daT.printBT("Pre");
        System.out.println("Here are the elements in the Binary Tree post-order.");
        daT.printBT("Post");
        System.out.println(daT.search(2));
        System.out.println(daT.search(5));
        daT.insert(1);
        daT.insert(5);
        daT.insert(6);
        daT.insert(7);
        System.out.println("Here are the elements in the Binary Tree in-order.");
        daT.printBT();
        System.out.println("Root = " + daT.getRoot());
        daT.delete(2);
        System.out.println("Here are the elements in the Binary Tree in-order.");
        daT.printBT();
        System.out.println("Root = " + daT.getRoot());

    }

}
