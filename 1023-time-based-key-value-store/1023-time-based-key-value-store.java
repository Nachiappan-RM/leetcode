class TimeMap {
    class Pair{
        int timestamp;
        String value;
        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    /**
    To find the nearest in sorted -> Binary Search
    HashMap<String, List<Pair>>
            Key           pair->timestamp, Value
     */
    HashMap<String, List<Pair>> timemap;
    public TimeMap() {
        this.timemap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timemap.containsKey(key)){
            timemap.put(key, new ArrayList<>());
        }
        Pair p = new Pair(timestamp, value);
        timemap.get(key).add(p);
    }
    
    public String get(String key, int timestamp) {
        if(!timemap.containsKey(key)){
            return "";
        }

        List<Pair> pairList = timemap.get(key);
        int start = 0;
        int end = pairList.size()-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(pairList.get(mid).timestamp == timestamp) return pairList.get(mid).value;
            else if(pairList.get(mid).timestamp > timestamp) end = mid-1;
            else start = mid + 1; 
        }

        if(start>0){
            return pairList.get(start-1).value;
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */