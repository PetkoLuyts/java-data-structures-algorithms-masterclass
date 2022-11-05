package linked_list;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public static class Node {
        public int value;
        public Node next;
        public Node prev;
    }

    public void createLinkedList(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void insertNode(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void traverseLinkedList() {
        Node tempNode = head;

        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value);

            if (i != size - 1) {
                System.out.print(" -> ");
            }

            tempNode = tempNode.next;
        }

        System.out.println();
    }
}
