class MyHashMap {
    public static class Entry{
        int key;
        int value;
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
        
    }
Entry[] table;
    int capacity;
    public MyHashMap() {
        this.capacity = 10000001;
        this.table = new Entry[this.capacity];
    }
    
    public void put(int key, int value) {
        Entry entry = new Entry(key, value);
        int hash = getHash(key);
        table[hash] = entry;
    }
    
    public int get(int key) {
        int hash = getHash(key);
        Entry entry = table[hash];
        return entry == null ? -1 : entry.value;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        table[hash] = null;
        
    }
    public int getHash(int key){
       return Math.abs(Integer.valueOf(key).hashCode()) % this.capacity;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */