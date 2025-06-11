class Solution {
    // public List<List<String>> groupAnagrams(String[] strs) {

    //     boolean[] isChecked = new boolean[strs.length];
    //     List<List<String>> res = new ArrayList<>();

    //     for(int i=0; i<strs.length; i++){
    //         if(!isChecked[i]){
    //             List<String> anagrams = new ArrayList<>();
    //             anagrams.add(strs[i]);
    //             isChecked[i] = true;
    //             for(int j=i+1; j<strs.length; j++){
    //                 if(isAnagram(strs[i], strs[j])){
    //                     isChecked[j] = true;
    //                     anagrams.add(strs[j]);
    //                 }
    //             }
    //             res.add(anagrams);
    //         }
    //     }
    //     return res;
    // }

    // private boolean isAnagram(String s1, String s2){
    //     if(s1.length()!=s2.length()){
    //         return false;
    //     }
    //     boolean[] isCharChecked = new boolean[s2.length()];

    //     for(int i=0; i<s1.length(); i++){
    //         for(int j=0; j<s2.length(); j++){
    //             if(!isCharChecked[j] && s1.charAt(i) == s2.charAt(j)){
    //                 isCharChecked[j] = true;
    //                 break;
    //             }
    //         }
    //     }
    //     for(int i=0;i<s2.length();i++){
    //         if(!isCharChecked[i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    /**
    Inital thought would be,
    Having a list of hashMap for all the words in the strs,
    Compare each map with others and group the similar ones
    TC - O(n^2*m) -(n being number of strs and m being max unique character in one str)
    SC - (n*m)

    Since given that its only going to be lowercase english letters,
    We need 26 array for n strs -> O(n) Space Complexity
    We need isAdded[n] array - To say thats being added to result,
    Take first string array and compare with others and if its same 
        add it to the array and at last add it to the result

    -O(n^2)

    But this is quite expensive process,

    So thinking of sorting
    I think of sort all n str -> TC = O(longm * n) ; m being max string length

    Put it into a HashMap,
    Sorted str -> index

    SC O(n)

    We can look up this hashmap to build the result

     */
    public List<List<String>> groupAnagrams(String[] strs){
        int n = strs.length;
        Map<String, List<String>> strToIndices = new HashMap<>();  
        for(int i=0; i<n; i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            strToIndices.computeIfAbsent(sorted, k-> new ArrayList<String>()).add(strs[i]);
        }

        List<List<String>> groupedAnagrams = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: strToIndices.entrySet()){
            groupedAnagrams.add(entry.getValue());
        }    
        return groupedAnagrams;
    }
}