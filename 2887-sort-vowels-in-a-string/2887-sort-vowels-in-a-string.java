class Solution {
    // Vowels in increasing ASCII order
    private static final char[] VOW = {
        'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'
    };
    public String sortVowels(String s) {
        int n = s.length();

        int[] cnts = new int[10];

        //1-cnt frq
        for(int i =0; i<n; i++) {
            char c = s.charAt(i);
            for(int j=0; j<10; j++) {
                if( c == VOW[j]) {
                    cnts[j]++;
                    break;
                }
            }
        }

        // 2-contrcut sorted vow t
        StringBuilder sb = new StringBuilder(n);
        int k = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            boolean appended = false;
            for(int j=0; j<10; j++) {
                if(c == VOW[j]) {
                    while(cnts[k] == 0) {
                        k++;
                    }
                    sb.append(VOW[k]);
                    cnts[k]--;
                    appended = true;
                    break;
                }
            }
            if(!appended) {
                //not vow
                sb.append(c);
            }
        }

        return sb.toString();
    }
}