package hash;

public class HashTable {
    private static final float LOADFACTOR = 0.75f;

    private static class Table{
        int hash;
        Object key;
        Object value;
        Table next;
        public Table(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public Table() {
        }
    }

    Table[] table = new Table[16];
    int size = 0;
    int threshold = (int) (LOADFACTOR*table.length);

    Object get(int hash, Object key) {
        int hashId = hash & (table.length - 1);
        //spacial 此处还是null
        if(table[hashId] == null){
            return null;
        }

        Table p = table[hashId];
        while(p != null){
            if(p.key.equals(key)){
                return p.value;
            }
            p = p.next;
        }
        return null;
    }
    boolean put(int hash, Object key, Object value) {
        int hashId = hash & (table.length - 1);
        if(table[hashId] == null){
            table[hashId] = new Table(hash, key, value);
            size++;
            return true;
        }
        Table p = table[hashId];
        while(true){
            if(p.key.equals(key)){
                p.value = value;
                return true;
            }
            if(p.next == null){
                p.next = new Table(hashId, key, value);
                size++;
                return true;
            }
            p = p.next;
        }
    }
    boolean delete(int hash, Object key) {
        int hashId = hash & (table.length - 1);
        if(table[hashId] == null){
            return false;
        }

        Table head = table[hashId];
        if (head.key.equals(key)) {
            // 头指针直接后移一位
            table[hashId] = head.next;
            size--;
            return true;
        }

        Table p = head;
        while (p.next != null) {
            // p.next 就是当前要对比的节点
            if (p.next.key.equals(key)) {
                p.next = p.next.next;
                size--;
                return true;
            }
            p = p.next;
        }
        return false;
    }
}
