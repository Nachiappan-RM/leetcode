class Solution {
    // public int maxProfit(int[] prices) {
    //     /*
    //         keep track of min till the ith value and compute the max diff
    //     */
    //     int min = prices[0];
    //     int profit = 0;
    //     for(int i=1; i<prices.length; i++){
    //         profit = prices[i]-min > profit ? prices[i]-min : profit;
    //         if(prices[i] < min){
    //             min = prices[i];
    //         }
    //     }
    //     return profit;
    // }
    //---------REVISION----------
    public int maxProfit(int[] prices){
        /**
        We need to get the make difference window
        So I'll keep the window like,
        2 pointers
        have a value for max price
        if no profit slide the window from left
        ig not just cacluate the profit and expand right

        [7,1,5,3,6,4]
        [7,5,1,2,3,6,4]
         */

        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int profit = 0;
        int buy = 0, sell = 1;
        while(sell<n){
            if(prices[buy] > prices[sell]){
                buy = sell;
                sell = buy+1;
            }else{
                profit = Math.max(profit, prices[sell] - prices[buy]);
                sell++;
            }
        }
        return profit;
    }
}