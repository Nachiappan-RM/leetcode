/**
if any words that's not of the required length we can leave them
if end word is not in the word list -> 0

Check possiblity to change every letter and see whether we can reach the 


We need shortest transfromation -> Thinking of BFS

Thinking of Trie Structure,
But here only lower case - trying to use 26 next char 
 */

class Solution {
    static class Form {
        StringBuilder word;
        int forms;
        Form(String word, int forms) {
            this.word = new StringBuilder(word);
            this.forms = forms;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || beginWord == null || endWord == null) {
            return 0;
        }

        int len = beginWord.length();
        if(len == 0) {
            return 0;
        }

        HashSet<String> wordSet = new HashSet<>();
        for(String word : wordList) {
            wordSet.add(word);
        }

        Queue<Form> queue = new LinkedList<>();
        queue.offer(new Form(beginWord, 1));
        int result = -1;
        while(!queue.isEmpty()) {
            Form form = queue.poll();
            if(endWord.equals(form.word.toString())) {
                result = form.forms;
                break;
            }
            StringBuilder currWord = form.word;
            for(int i=0; i<currWord.length(); i++) {
                for(int j=0; j<26; j++) {
                    StringBuilder newWord = new StringBuilder(currWord);
                    newWord.setCharAt(i, (char) (j+'a'));
                    if(!newWord.toString().equals(currWord.toString()) && wordSet.contains(newWord.toString())) {
                        queue.offer(new Form(newWord.toString(), form.forms+1));
                        wordSet.remove(newWord.toString()); // Mark as visited
                    }
                }
            }
        }

        return Math.max(0, result);
    }
}