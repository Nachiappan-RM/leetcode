class Solution {
    Map<Character, List<Character>> digitToLetters = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        /**
        Just to create a hashmap with list of possible letters,and try to look up all possible letters in there,
         */

        digitToLetters.put('2', Arrays.asList('a', 'b', 'c'));
        digitToLetters.put('3', Arrays.asList('d', 'e', 'f'));
        digitToLetters.put('4', Arrays.asList('g', 'h', 'i'));
        digitToLetters.put('5', Arrays.asList('j', 'k', 'l'));
        digitToLetters.put('6', Arrays.asList('m', 'n', 'o'));
        digitToLetters.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitToLetters.put('8', Arrays.asList('t', 'u', 'v'));
        digitToLetters.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        if (digits == null || digits.equals("") || digits.length() == 0) {
            return result;
        }
        computeCombinations(digits, new StringBuilder(), 0, result);
        return result;
    }

    private void computeCombinations(String digits,
            StringBuilder curr,
            int ind, List<String> result) {
        if (ind == digits.length()) {
            result.add(curr.toString());
            return;
        }
        for (Character next : digitToLetters.get(digits.charAt(ind))) {
            curr.append(next);            
            computeCombinations(digits, curr, ind + 1, result);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}