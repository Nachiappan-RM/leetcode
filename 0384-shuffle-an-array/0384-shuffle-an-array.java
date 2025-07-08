/**

You are givein an array write an algorithm to randomize or shuffle it whenever we can shuffle method and return
whenever we call reset it has to be restted to original and return

All perumutation should be have equal probablity.

*/

class Solution {
    private int[] original;
    private int[] array;
    private Random random;
    
    public Solution(int[] nums) {
        original = nums.clone();    
        array = nums.clone();
        random = new Random();
    }
    
    public int[] reset() {
        array = original.clone();
        return array;
    }
    
    public int[] shuffle() {

        for(int i=array.length - 1; i>0; i--) {
            int j = random.nextInt(i+1);
            //Swap elements at position i and j
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
