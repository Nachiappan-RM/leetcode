class Solution {
    /**
    We can start at any point and has to reach that point then we can return that index
    currentGas = 0
    We add the gas[i]+currentGas>=cost -> currentGas-cost (Look for circular)

    if we checj each index as potential start and look for circular possiblity
    time : O(n^2)

    Greedy approach,
    To see the gas needed - We can see where the gas getting possitive residue -> potential index

    At the end if we didn't get possitive then return -1
    time - O(n)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int tank = 0;
        int start = 0;
        for(int i = 0; i<gas.length; i++) {
            int diff = gas[i] - cost[i];
            tank += diff;
            totalTank += diff;

            if(tank<0) {
                start = i+1; //Next index;
                tank = 0;
            }
        }

        return totalTank >= 0 ? start : -1;
    }
    /**
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startIndex = 0;
        int n = gas.length;
        for(int i=0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }
        return totalGas >= totalCost ? startIndex : -1;
    }
    */
    /*
    //Brute Force
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i<gas.length; i++){
            if(gas[i]>= cost[i]){
                if(isCircular(gas, cost, i)){
                    return i;
                }
            }
        }

        return -1;
    }

    private boolean isCircular(int[] gas, int[] cost, int start){
        int rem = gas[start] - cost[start];
        int n = gas.length;
        int i=(start+1)%n;
        while(i!=start){
            rem = rem + gas[i] - cost[i];
            if(rem<0){
                return false;
            }
            i = (i+1)%n;
        }
        return true;
    }
    */
}