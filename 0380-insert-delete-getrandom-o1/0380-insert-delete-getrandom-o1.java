class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> indexMap;
    Random random;
    int size;
    public RandomizedSet() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
        size = 0;
    }
    
    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return false;
        }
        list.add(val);
        indexMap.put(val,list.size()-1);
        size++;
        return true;
    }
    
    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
            return false;
        }
        int index = indexMap.get(val);
        int lastElement = list.get(size-1);
        list.set(index, lastElement);
        indexMap.put(lastElement, index);
        list.remove(size-1);
        indexMap.remove(val);
        size--;
        return true;
    }
    
    public int getRandom() {
        int r = random.nextInt(size);
        return list.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */