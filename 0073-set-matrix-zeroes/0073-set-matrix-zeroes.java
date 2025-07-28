
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false, column = false;
        int n = matrix[0].length;
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row = true;
                    }
                    if (j == 0) {
                        column = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;

                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (column) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (row) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}

// class Solution {
//     public void setZeroes(int[][] matrix) {
//       /*
//       Idea
//       Create 2 Sets,
//        row mask
//        column mask
//       Find all the indices with 0 and push it to that respective sets
//       Traverse the set and make all the rows and columns from that indices set zero.
//       */  
//     HashSet<Integer> columnMask = new HashSet<>(matrix[0].length);
//     HashSet<Integer> rowMask = new HashSet<>(matrix.length);

//     for(int i=0; i<matrix.length; i++){
//         for(int j=0; j<matrix[i].length; j++){
//             if(matrix[i][j] == 0){
//                 rowMask.add(i);
//                 columnMask.add(j);
//             }
//         }
//     }

//     if(rowMask.size()>0){
//         // Iterator<Integer> rIter = rowMask.iterator();
//         // System.out.println("Row");

//         // while(rIter.hasNext()){
//         //     for(int col=0; col<matrix[0].length; col++){
//         //         System.out.println(rIter.next());
//         //         // matrix[rIter.next()][col] = 0;    
//         //     }
//         // }

//         for (int r : rowMask){
//             for(int col=0; col<matrix[0].length; col++){
//                 matrix[r][col] = 0;    
//             }
//         } 
//     }

//     if(columnMask.size()>0){
//         // System.out.println("Column");
//         // Iterator<Integer> cIter = columnMask.iterator();

//         // while(cIter.hasNext()){
//         //     for(int row=0; row<matrix.length; row++){
//         //         System.out.println(cIter.next());
//         //         // matrix[row][cIter.next()] = 0;    
//         //     }
//         // }

//         for (int c : columnMask){
//             for(int row=0; row<matrix.length; row++){
//                 matrix[row][c] = 0;    
//             }
//         } 

//     }

//     }
// }