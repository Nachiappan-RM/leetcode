/*
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize!=0){
            return false;
        }

        Arrays.sort(hand);

        Map<Integer, Integer> cnt = new HashMap<>();
        countCharacter(hand, cnt);

        for (int num : hand) {
            if (cnt.get(num) == 0) {
                continue; // Skip numbers that have already been used up
            }
            int m = cnt.get(num);
            for (int i = 0; i < groupSize; i++) {
                int currentNum = num + i;
                if (cnt.getOrDefault(currentNum, 0) < m) {
                    return false;
                }
                cnt.put(currentNum, cnt.get(currentNum) - m);
            }
        }
        return true;
    }
    private void countCharacter(int[] hand, Map<Integer, Integer> cnt) {
        for (int h : hand) {
            cnt.put(h, cnt.getOrDefault(h, 0) + 1);
        }
    }
}
*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n%groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for(int card : hand) {
            freq.put(card, freq.getOrDefault(card,0) + 1);
        }

        for(int start: freq.keySet()) {
            //How many groups must start with start
            int count = freq.get(start);
            if(count>0) {
                for(int offset = 0; offset<groupSize; offset++) {
                    int curr = start+offset;
                    if(freq.getOrDefault(curr, 0) < count) {
                        return false;
                    }
                    //Use up count cards of value curr
                    freq.put(curr, freq.get(curr) - count);
                }
            }
        }

        //If we never failed it's possible
        return true;
    }
}