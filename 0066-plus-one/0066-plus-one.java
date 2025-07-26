/*
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and move towards the first digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // Set current digit to 0 and carry over
        }
        
        // If we reach here, all digits were 9 and turned into 0
        // So we need to create a new array of size n + 1
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1; // The carry over to the most significant position
        return newNumber;
    }
}
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int c = 1;
        for(int i = n-1; i>=0; i--) {
            int sum = digits[i] + c;
            digits[i] = sum%10;
            c = sum/10;
        }

        if(c!=0) {
            int[] sum = new int[n+1];
            sum[0] = c;
            for(int i=0; i<n; i++) {
                sum[i+1] = digits[i];
            }
            return sum;
        }

        return digits;
    }
}