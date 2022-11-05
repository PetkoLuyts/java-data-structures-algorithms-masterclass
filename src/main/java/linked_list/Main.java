package linked_list;

public class Main {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        l1.insertNode(7);
        l1.insertNode(1);
        l1.insertNode(6);

        l2.insertNode(5);
        l2.insertNode(9);
        l2.insertNode(2);

        LinkedList result = new LinkedList();
        LinkedList result1 = result.sumLists(l1, l2);
        result1.traverseLinkedList();
    }
}
