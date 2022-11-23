package hashing;

import java.util.ArrayList;

public class DoubleHashing {
    String[] hashTable;
    int usedCellNumber;

    public DoubleHashing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
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

    private int addAllDigitsTogether(int sum) {
        int value = 0;

        while (sum > 0) {
            value = sum % 10;
            sum /= 10;
        }

        return value;
    }

    public int secondHashFunction(String x, int M) {
        char ch[];
        ch = x.toCharArray();
        int i, sum;

        for (sum = 0, i = 0; i < x.length(); i++) {
            sum += ch[i];
        }

        while (sum > hashTable.length) {
            sum = addAllDigitsTogether(sum);
        }

        return sum % M;
    }

    public double getLoadFactor() {
        return usedCellNumber * 1.0/hashTable.length;
    }

    public void rehashKeys(String word) {
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<>();

        for (String s : hashTable) {
            if (s != null) {
                data.add(s);
            }
        }

        data.add(word);
        hashTable = new String[hashTable.length * 2];

        for (String s : data) {
            insertKeyInHashTable(s);
        }
    }

    public void insertKeyInHashTable(String value) {
        double loadFactor = getLoadFactor();

        if (loadFactor >= 0.75) {
            rehashKeys(value);
        } else {
            int x = modASCIIHashFunction(value, hashTable.length);
            int y = secondHashFunction(value, hashTable.length);

            for (int i = 0; i < hashTable.length; i++) {
                int newIndex = (x + i * y) % hashTable.length;

                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = value;
                    System.out.println(value + " inserted at location: " + newIndex);
                    break;
                } else {
                    System.out.println(newIndex + " is already occupied. Trying next one...");
                }
            }
        }

        usedCellNumber++;
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

}
