/**
 * BFS
 * Time : O(N*26^l) l is the length of the word
 * Space: O(N) N means the number of the wordList
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        
        if (!dict.contains(endWord)){
            return 0;
        }
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        
        int steps = 1;
        
        while (!reached.contains(endWord)){
            Set<String> next = new HashSet<>();
            for (String w : reached){
                for (int i = 0; i < w.length();i++){
                    char[] word = w.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++){
                        word[i] = ch;
                        String curWord = new String(word);
                        if (dict.contains(curWord)){
                            next.add(curWord);
                            
                            // this is important, since once you find it,
                            // you dont need to find again later, therefore remove it
                            dict.remove(curWord);
                        }
                    }
                }
            }
            
            // when you cannot find any next element,
            // meaning you obviously cannot find the enWord neither
            if (next.size() == 0) return 0;
            steps++;
            reached = next;
        }
        
        return steps;
    }
}
