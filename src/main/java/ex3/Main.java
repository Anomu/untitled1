package ex3;

import ex2.HashTable;

public class Main {
    public static void main(String[] args) {
        ex2.HashTable hashTable = new HashTable();

        // Put some key values.
        for (int i = 0; i < 30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, key);
        }

       /* // Print the HashTable structure
        HashTable.log("****   HashTable  ***");
        HashTable.log(hashTable.toString());
        HashTable.log("\nValue for key(20) : " + hashTable.get("20"));

        */

        System.out.println("****   HashTable  ***");
        System.out.println(hashTable.toString());
        System.out.printf("\nValue for key(20) : " + hashTable.get("20"));

    }
}