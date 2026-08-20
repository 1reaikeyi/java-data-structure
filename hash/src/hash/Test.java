package hash;

public class Test {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(0,"1","a");
        hashTable.put(1,"1","b");
        hashTable.put(2,"1","c");
        System.out.println(hashTable.get(0,"1"));
        System.out.println(hashTable.get(1,"1"));
        System.out.println(hashTable.get(2,"1"));
    }
}

