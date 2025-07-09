// class Trie {
//     class TrieNode {
//         TrieNode[] children;
//         boolean isEndOfWord;

//         public TrieNode() {
//             children = new TrieNode[26];
//             isEndOfWord = false;
//         }
//     }
    
//     TrieNode root;
    
//     public Trie() {
//         root = new TrieNode();
//      }
    
//     public void insert(String word) {
//         TrieNode curr = root;
//         for(int i=0; i<word.length(); i++){
//             if(curr.children[word.charAt(i)-'a'] == null){
//                 curr.children[word.charAt(i)-'a'] = new TrieNode();
//             }
//             curr = curr.children[word.charAt(i)-'a'];
//         }
//         curr.isEndOfWord = true;
//     }
    
//     public boolean search(String word) {
//         TrieNode curr = root;
//         for(int i=0; i<word.length(); i++){
//             if(curr == null || curr.children[word.charAt(i)-'a'] == null){
//                 return false;
//             }
//             curr = curr.children[word.charAt(i)-'a'];
//         }
//         return (curr == null) ? false: curr.isEndOfWord;
//     }
    
//     public boolean startsWith(String prefix) {
//         TrieNode curr = root;
//         for(int i=0; i<prefix.length(); i++){
//             if(curr == null || curr.children[prefix.charAt(i)-'a'] == null){
//                 return false;
//             }
//             curr = curr.children[prefix.charAt(i)-'a'];
//         }
//         return curr != null;
//     }
// }

// /**
//  * Your Trie object will be instantiated and called as such:
//  * Trie obj = new Trie();
//  * obj.insert(word);
//  * boolean param_2 = obj.search(word);
//  * boolean param_3 = obj.startsWith(prefix);
//  */


// ----------- REVISION -------------
/**
- Is it only lowercase?
 */
class Trie {
    class TrieNode {
        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26]; 
        }
        boolean isEnd;
        TrieNode children[];
    }
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isEnd = true;
    }

    boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c-'a'] == null) {
                return false;
            }
            node = node.children[c-'a'];
        }
        return (node != null) ? node.isEnd : false;
    }

    boolean startsWith(String prefix) {
        TrieNode node = root;

        for(char c : prefix.toCharArray()) {
            if(node.children[c-'a'] == null) {
                return false;
            }
            node = node.children[c-'a'];
        }
        return node != null;
    }
}