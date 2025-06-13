class Solution {
    // public int[] productExceptSelf(int[] nums) {
    //     /* O(n) -> Product fit in int ; Can't use Division */
    //     /* Result array with 1, Go over everything in the array and multiply it in the array if its not the same index - O(n) */

    //     int n = nums.length;
    //     int[] products = new int[n];

    //     for(int i=0; i<n; i++){
    //         products[i] = 1;
    //     }
    //     // for(int i=0; i<n; i++){ //O(n^2)
    //     //     for(int j=0; j<n; j++){
    //     //         if(i!=j){
    //     //             products[i]*=nums[j];
    //     //         }
    //     //     }
    //     // }

    //     // O(n+n+n) and extra space of O(n+n)
    //     // int[] prefix = new int[n+1];
    //     // int[] suffix = new int[n+1];
    //     // prefix[0] = 1;
    //     // suffix[n] = 1;
    //     // for(int i=0; i<n; i++){
    //     //     prefix[i+1] = prefix[i]*nums[i];
    //     // }
    //     // System.out.println(Arrays.toString(prefix));
    //     // for(int i=n-1; i>=0; i--){
    //     //     suffix[i] = suffix[i+1]*nums[i];
    //     // }
    //     // // System.out.println(Arrays.toString(suffix));

    //     // for(int i=0;i<n;i++){
    //     //     products[i] = prefix[i]*suffix[i+1];
    //     // }

        
    //     for(int i=1; i<n; i++){
    //         products[i] = products[i-1]*nums[i-1];
    //     }
    //     // System.out.println(Arrays.toString(products));
    //     int suffixProduct = nums[n-1];
    //     for(int i=n-2; i>=0; i--){
    //         products[i] = products[i]*suffixProduct;
    //         suffixProduct *= nums[i];
    //     }

    //     return products;
    // }

    /**
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]

        output: [2*3*4 , 1*2*4, 1*2*4, 1*2*3]

        prefix product -> [1,1,2,6,24]
        suffix product -> [24,24,12,4,1]

        Every index starting from 1'st in prefix -> Do product of i+1 in suffix and i-1 in prefix
         */
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] prefixProduct = new int[n+1];
        int[] suffixProduct = new int[n+1];

        //Setting first of prefix and last of suffix to 1 (Because of its commutative prop)
        prefixProduct[0] = 1;
        suffixProduct[n] = 1;

        for(int i=0; i<n; i++){
            prefixProduct[i+1] = prefixProduct[i]*nums[i];
        }

        for(int i=n-1; i>=0; i--){
            suffixProduct[i] = suffixProduct[i+1]*nums[i];
        }

        int[] productOfArrayExeptSelf = new int[n];
        for(int i=0;i<n;i++){
            productOfArrayExeptSelf[i] = prefixProduct[i] * suffixProduct[i+1];
        }
        return productOfArrayExeptSelf;
    }
}