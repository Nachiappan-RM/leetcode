// class Solution {
//     TrieNode root = new TrieNode();
//     // dfs + Trie
//     int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

//     public List<String> findWords(char[][] board, String[] words) {
//         Set<String> result = new HashSet<>();
//         int m = board.length;
//         if(words.length == 0 || m ==0) return new ArrayList<String>();
//         int n = board[0].length;

//         for (String word : words) {
//             insert(word);
//         }
//         // System.out.println("m->"+m+" n->"+n);
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (root.children[board[i][j] - 'a'] != null) { //potential start point
//                     dfs(board, new boolean[m][n], root, i, j, m, n, result);
//                 }
//                 // System.out.println();
//             }
//         }
//         return new ArrayList<String>(result);
//     }

//     private void dfs(char[][] board, boolean[][] isVisited, TrieNode root, int i, int j, int m, int n,
//             Set<String> result) {
//         if (root.word != null) {
//             result.add(root.word);
//         }

//         if (i < 0 || j < 0 || i >= m || j >= n || isVisited[i][j] || root == null
//                 || root.children[board[i][j] - 'a'] == null) {
//             return;
//         }
        
//         // System.out.println(board[i][j]);
//         isVisited[i][j] = true;
//         for (int[] dir : directions) {
//             dfs(board, isVisited, root.children[board[i][j] - 'a'], i + dir[0], j + dir[1], m, n, result);
//         }
//         isVisited[i][j] = false; //Backtrack
//     }

//     private void insert(String s) {
//         TrieNode curr = root;
//         for (int i = 0; i < s.length(); i++) {
//             if (curr.children[s.charAt(i) - 'a'] == null) {
//                 curr.children[s.charAt(i) - 'a'] = new TrieNode();
//             }
//             curr = curr.children[s.charAt(i) - 'a'];
//         }
//         curr.isEnd = true;
//         curr.word = s;
//     }

//     class TrieNode {
//         TrieNode[] children = new TrieNode[26];
//         boolean isEnd = false;
//         String word;
//     }

// }


// ------------ REVISION ---------
class Solution {
    private final int[][] DIRECTIONS = {{1,0}, {0,1}, {-1, 0}, {0, -1}}; //4-adjacent directions

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> wordsFound = new HashSet<>(); //There are cases that we would end up having duplicates to get rid of that
        TrieNode root = new TrieNode();

        for(String word : words) {
            insert(word, root);
        }

        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if( root.children[board[i][j] - 'a'] != null) { //Potential start point
                    // dfs
                    dfs(board, i, j, m, n, root, wordsFound, new boolean[m][n]);
                }
            }
        }
        return new ArrayList<>(wordsFound);
    }

    private void dfs(char[][] board, int i, int j, int m, int n, TrieNode node, HashSet wordsFound, boolean[][] isVisited) {
        if(i>=m || i<0 || j<0 ||  j>=n || node == null || isVisited[i][j] || node.children[board[i][j]-'a'] == null) {
            return;
        }

        isVisited[i][j] = true;
        node = node.children[board[i][j]-'a'];

        if(node.isEnd) {
            wordsFound.add(node.word);
        }
        for(int[] dir: DIRECTIONS) {
            dfs(board, i+dir[0], j+dir[1], m, n, node, wordsFound, isVisited);
        }

        isVisited[i][j] = false;
    }

    private void insert(String word, TrieNode root) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }

    class TrieNode {
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
            this.word = "";
        }
        TrieNode[] children;
        boolean isEnd;
        String word;
    }
}