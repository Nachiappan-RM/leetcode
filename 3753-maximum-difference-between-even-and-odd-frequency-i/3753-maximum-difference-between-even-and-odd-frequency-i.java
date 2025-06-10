class Solution {
    public int maxDifference(String s) {
        /**
        Get all frequencies and get the max odd freq and min even freq        
         */
        int oddMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;

        int[] freq = new int[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0; i<26; i++){
            if(freq[i]!=0 && freq[i]%2 == 0 && evenMin>freq[i]){
                evenMin = freq[i];
            }

            if(freq[i]%2 != 0 && oddMax<freq[i]){
                oddMax = freq[i];
            }
        }
        // System.out.println(oddMax);
        // System.out.println(evenMin);
        return oddMax-evenMin ;
    }
}