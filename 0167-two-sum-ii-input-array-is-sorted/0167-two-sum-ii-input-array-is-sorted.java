class Solution {
    // public int[] twoSum(int[] numbers, int target) {
    //     /**
    //     Keys:
    //     - Sorted arr input
    //     - Definetly there will be answer exactly one answer.

    //     Approaches thought:
    //     - 2 pointers -> I could have a pointer in left and another one on the right most
    //     [2,7,11,15]  target - 9
    //      ^       *
    //      cases,
    //      1. i+j == target -> return indexs
    //      2. i+j > target j-- 
    //      3. i+j<target i++
    //     O(n)
    //      Another approach is using Binary search
    //      We can use binary search to search for it's complement in the right halve
    //      -(n * logn)
    //     */

    //     int i=0, j = numbers.length-1;
    //     int[] result = new int[2];
    //     while(i<j){
    //         if(numbers[i]+numbers[j] == target){
    //             result[0] = i+1;
    //             result[1] = j+1;
    //             break;
    //         }else if(numbers[i] +numbers[j] > target) j--;
    //         else i++;
    //     }
    //     return result;
    // }

    // -------REVISION--------
    public int[] twoSum(int[] numbers, int target){
        int[] result = new int[2];
        //No way this is happening just for edge case
        if(numbers == null || numbers.length == 0){
            return result;
        }

        result[0] = 1;
        result[1] = numbers.length;
        while(result[0]<result[1]){
            int sum = numbers[result[0]-1]+numbers[result[1]-1];
            if(sum == target){
                return result;
            }else if(sum<target){
                result[0]++;
            }else{
                result[1]--;
            }
        }
        return result;
    }
}