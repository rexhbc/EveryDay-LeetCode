/**
 * Time:  O(N)
 * Space: O(length of string p)
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || p.length() > s.length()){
            return result;
        }
        
        Map<Character, Integer> map = countMap(p);
        int match = 0;
        
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            Integer count = map.get(cur);
            if (count != null){
                map.put(cur, count-1);
                if (map.get(cur) == 0){
                    match++;
                }
            }
            // if count is null, meaning it is not existed in anagram string, so you continue
            
            if (i >= p.length()){
                cur = s.charAt(i-p.length());
                count = map.get(cur);
                
                if (count != null){
                    map.put(cur, count+1);
                    if (map.get(cur) > 0){
                        match--;
                    }
                }
            }
            
            if (match == map.size()){
                result.add(i-p.length()+1);
            }
        }
        
        return result;
    }
    
    private Map<Character, Integer> countMap(String p){
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        return map;
    }
}


