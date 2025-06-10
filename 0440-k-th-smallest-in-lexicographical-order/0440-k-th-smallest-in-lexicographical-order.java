class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        while(k>0){
            long count = 0;
            long first = current;
            long last = current +1;
            while(first<=n){
                count += Math.min(n+1, last) - first;
                first *= 10;
                last *= 10;
            }

            if(k<count){
                current *= 10;
                k--;
            }
            else{
                current++;
                k-=count;
            }
        }

        return current;
    }
}

/**

Given 2 numbers,
n and k
return the kth lexicographically smallest integer in the range [1, n]

Example,
n=13, k=2

1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9
So 2nd smallest is 10
 
 n=13 k=2
 1. Initialize current=1, k=1 (after decrement)
 2. calc count of nodes with prefix 1:
 - Numbers with prefix 1: 1, 10, 11, 12, 13
 - count 5
 3. since k(1) < count(5) look down the tree: current =10, k=0
 4. return 10

 */