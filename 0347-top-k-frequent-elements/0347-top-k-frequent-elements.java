class Solution {
    /*
    class CharacterFrequency{
        int number;
        int frequency;
        public CharacterFrequency(int number,int frequency){
            this.number = number;
            this.frequency = frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<CharacterFrequency> minHeap = new PriorityQueue<>(
            new Comparator<CharacterFrequency>(){
                @Override
                public int compare(CharacterFrequency c1, CharacterFrequency c2){
                    return Integer.compare(c1.frequency, c2.frequency);
                }
            }
        );

        HashMap<Integer, CharacterFrequency> map = new HashMap<>();

        for(int num: nums){
            if(!map.containsKey(num)){
                CharacterFrequency cf = new CharacterFrequency(num, 1);
                map.put(num, cf);
            }else{
                map.get(num).frequency = map.get(num).frequency+1;
            }
        }

        for(Map.Entry<Integer, CharacterFrequency> v : map.entrySet()){
            if(minHeap.size()<k){
                minHeap.offer(v.getValue());
            }else if(minHeap.peek().frequency<v.getValue().frequency){
                minHeap.poll();
                minHeap.offer(v.getValue());
            }
        }
        int[] topKFreq = new int[k];
        int i=0;
        while(i<k){
            topKFreq[i++] = minHeap.poll().number;
        }
        return topKFreq;
    }
    */

    //-------------Revisition-----------
    public int[] topKFrequent(int[] nums, int k){
        /**
        Try to build a Hashmap with number->freq 

        Build a MinHeap with k max values and return the root
        Iterate over the map and push the Entry into heap

        Questions:
        - What to do if k=0?
        - What to do if we have two numbers with same frequency in k? - Can we return any number?

         */
        
        HashMap<Integer, Integer> numsFreq = new HashMap<>();
        
        for(int num: nums){
            if(!numsFreq.containsKey(num)){
                numsFreq.put(num, 1);
            }else{
                numsFreq.put(num, numsFreq.get(num)+1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            new Comparator<Map.Entry<Integer, Integer>>(){
                @Override
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                    return Integer.compare(e1.getValue(), e2.getValue());
                }
            }
        );

        for(Map.Entry<Integer, Integer> entry: numsFreq.entrySet()){
            if(minHeap.size()<k){
                minHeap.offer(entry);
            }else if(minHeap.peek().getValue()<numsFreq.get(entry.getKey())){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        int[] result = new int[k];
        int i=k-1;
        while(i>=0){
            result[i--] = minHeap.peek().getKey();
            minHeap.poll();
        }
        return result;
    }
}