package linked_list;

import java.util.HashSet;

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
        if (head == null) {
            createLinkedList(nodeValue);
            return;
        }

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

    public void deleteDuplicates() {
        HashSet<Integer> hashSet = new HashSet<>();

        Node current = head;
        Node prev = null;

        while (current != null) {
            int currentValue = current.value;

            if (hashSet.contains(currentValue)) {
                prev.next = current.next;
                size--;
            } else {
                hashSet.add(currentValue);
                prev = current;
            }

            current = current.next;
        }
    }

    public Node nthToLast(int n) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < n; i++) {
            if (p2 == null) return null;

            p2 = p2.next;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public LinkedList partition(int x) {
        Node currentNode = head;
        tail = head;

        while (currentNode != null) {
            Node next = currentNode.next;

            if (currentNode.value < x) {
                currentNode.next = head;
                head = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
            }

            currentNode = next;
        }

        tail.next = null;
        return this;
    }

    public LinkedList sumLists(LinkedList l1, LinkedList l2) {
        Node n1 = l1.head;
        Node n2 = l2.head;
        int carry = 0;
        LinkedList resultList = new LinkedList();

        while (n1 != null || n2 != null) {
            int result = carry;

            if (n1 != null) {
                result += n1.value;
                n1 = n1.next;
            }
            if (n2 != null) {
                result += n2.value;
                n2 = n2.next;
            }

            resultList.insertNode(result % 10);
            carry = result / 10;
        }

        return resultList;
    }
}
