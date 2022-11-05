package linked_list;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.createLinkedList(1);
        linkedList.insertNode(2);
        linkedList.insertNode(3);
        linkedList.insertNode(2);
        linkedList.insertNode(5);

        linkedList.traverseLinkedList();

        LinkedList.Node n = linkedList.nthToLast(2);

        System.out.println(n.value);
    }
}
