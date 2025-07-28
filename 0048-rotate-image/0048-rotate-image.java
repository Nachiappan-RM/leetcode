// class Solution {
//     public void rotate(int[][] matrix) {
//         //In place Rotation

//         /*
//         Idea,

//         Moving accross like Spiral and rotating one row and one column at a time
//         Need temp[n-1];
//         SC - O(n)

//         TC - O(n^2)
//         */
//         int n = matrix.length;
//         // int[] temp = new int[n-1];
//         // int[] temp1 = new int[n-1];
//         // int[] temp2 = new int[n-1];
//         int l = 0; //Left column
//         int t = 0; // top row
//         int r = n-1; // right column
//         int b = n-1; // bottom row

        

//         while(b>t && r>l){ //Till middle

//         int[] temp = new int[r-l];
//         int[] temp1 = new int[r-l];
//         int[] temp2 = new int[r-l];
//         int ind = 0;
//         //Copy left column values to temp
//         for(int ll=l; ll<r; ll++){
//             temp[ind++] = matrix[ll][t];
//         }
//         printArray(temp, "temp");


//         //Move b->l
//         for(int i=l; i<=r; i++){
//             matrix[i][l] = matrix[b][i];
//         }

//         ind = 0;
//         //Copy top row values to temp1
//         for(int tt=l+1; tt<=r; tt++){
//             temp1[ind++] = matrix[t][tt]; //Copying from 1st index
//         }
//         printArray(temp1, "temp1");

//         ind=0;
//         //Copy right column values to temp
//         for(int rr=t+1; rr<=b; rr++){
//             temp2[ind++] = matrix[rr][r]; //Copying from 1st index
//         }
//         printArray(temp2, "temp2");

//         ind = 0;
//         //Move temp -> t (1st element in temp will be last element in t row)
//         for(int i=r; i>t; i--){
//             matrix[t][i] = temp[ind++];
//         }

//         ind = 0;
//         //Move temp1 -> r
//         for(int i=t; i<b; i++){
//             matrix[i+1][r] = temp1[ind++]; //update from 2nd row
//         }            
        
//         ind = temp2.length-1;
//         //Move temp -> b (1st element in temp will be last element in b row)
//         for(int i=l; i<r; i++){
//             matrix[b][i] = temp2[ind--];
//         }

//         l++;
//         r--;
//         t++;
//         b--;
//         }
        
//     }


//     public static void printArray(int[] arr, String name) {
//         System.out.println(name);
//         for (int i = 0; i < arr.length; i++) {
//             System.out.print(arr[i]);
//             // Print a space after each element except for the last one
//             if (i != arr.length - 1) {
//                 System.out.print(" ");
//             }
//         }
//         // Print a new line at the end
//         System.out.println();
//     }
// }

class Solution {
    public void rotate(int[][] matrix) {
        // Transform and reversing each row
        transform(matrix);
        reverseEachRow(matrix);
    }

    private void transform(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverseEachRow(int[][] matrix) {
        int n = matrix.length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}