package linked_list;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.createLinkedList(1);
        linkedList.insertNode(9);
        linkedList.insertNode(5);
        linkedList.insertNode(10);
        linkedList.insertNode(2);

        linkedList.traverseLinkedList();

        LinkedList.Node n = linkedList.nthToLast(2);

        linkedList = linkedList.partition( 4);

        linkedList.traverseLinkedList();
    }
}
