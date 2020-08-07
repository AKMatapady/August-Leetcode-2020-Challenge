class MyHashSet {
    
    private int range;
    private HashBucket[] buckets;
    
    class HashBucket
    {
        private LinkedList<Integer> sub;
        
        public HashBucket()
        {
            sub = new LinkedList<Integer>();
        }
        
        public boolean exists(int key)
        {
            int index = sub.indexOf(key);
            return (index>-1);
        }
        
        public void add(int key)
        {
            int index = sub.indexOf(key);
            if(index == -1)
            {
                sub.addFirst(key);
            }
        }
        
        public void remove(Integer key)
        {
            int index = sub.indexOf(key);
            if(index != -1)
            {
                sub.remove(key);
            }
        }
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        range = 1001;
        buckets = new HashBucket[range];
        for(int i = 0; i < range; i++)
        {
            buckets[i] = new HashBucket();
        }
    }
    
    private int hashValue(int key)
    {
        return (key % range);
    }
    
    public void add(int key) {
        int bucketIndex = hashValue(key);
        buckets[bucketIndex].add(key);
    }
    
    public void remove(int key) {
        int bucketIndex = hashValue(key);
        buckets[bucketIndex].remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = hashValue(key);
        return buckets[bucketIndex].exists(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */