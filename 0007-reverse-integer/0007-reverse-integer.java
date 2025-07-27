/**
class Solution {
    public int reverse(int x) {
        if(x<0){
            return -reverseNumber(0-x);
        }
        return reverseNumber(x);
    }

    int reverseNumber(int x){
        int n = x;
        int res = 0;
        while(n>0){
            int rem = n%10;
            res = (res)*10+rem;
            n = n/10;
            if(rem != res%10){
                return 0;
            }
        }
        return res;
    }
}
*/

class Solution {
    public int reverse(int x) {
        int n = x;
        int res = 0;
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        while ( n != 0) {
            int digit =  n%10;
            if(res > MAX/10 || (res == MAX/10 && digit > MAX%10)) {
                return 0;
            }
            if(res < MIN/10 || (res == MIN/10 && digit < MIN%10)) {
                return 0;
            }

            res = (res*10) + digit;
            n = n/10;

        }
        return res;
    }
}