class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return "0";
        if(num1.equals("0") || num2.equals("0")) return "0";

        //Initialize result with array with zeros
        int[] result = new int[num1.length()+num2.length()];

        // multiply each digit and add to result
        for(int i=num1.length()-1; i>=0; i--){
            for(int j=num2.length()-1; j>=0; j--){
                int product = (num1.charAt(i) - '0')* (num2.charAt(j)-'0');
                int sum = product + result[i+j+1]; //Adding to existing value

                result[i+j+1] = sum%10; //current position Value
                result[i+j] += sum/10; //carry
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int digit: result){
            //skip leading zeros
            if(!(sb.length() == 0 && digit == 0)){
                sb.append(digit);
            }
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
/**

Given 2 String numbers,

- Compute the multiplication of those 2 numbers and result should be in String,

- Numbers are going to be really very big

Example,

num1 = "10000" num2="54"

Output -> "540000"
 */