package hashing;

import java.util.LinkedList;

// DIRECT CHAINING COLLISION RESOLUTION TECHNIQUE
public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    public DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    public int modASCIIHashFunction(String word, int M) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;

        for (sum = 0, i = 0; i < word.length(); i++) {
            sum += ch[i];
        }

        return sum % M;
    }

    public void insertHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);

        if (hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<>();
            hashTable[newIndex].add(word);
        } else {
            hashTable[newIndex].add(word);
        }
    }

    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("The hashtable does not exist!");
            return;
        } else {
            System.out.println("--------Hashtable--------");

            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index " + i + ", key: " + hashTable[i]);
            }
        }
    }

    public boolean searchHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);

        if (hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {
            System.out.println(word + " found in hashtable at location: " + newIndex);
            return true;
        } else {
            System.out.println(word + " not found in hashtable");
            return false;
        }
    }

    public void deleteKeyHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        boolean exists = searchHashTable(word);

        if (exists) {
            hashTable[newIndex].remove(word);
            System.out.println(word + " has been deleted from hashtable");
        } else {
            System.out.println(word + " not found in hashtable");
        }
    }
}
