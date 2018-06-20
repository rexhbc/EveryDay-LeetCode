/**
 * Backtrack
 * Time : O(4^N) each level has most 4 braches
 * Space: O(N)
 * BUG : didnt consider the case when input is "";
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        DFS(result, sb, 0, digits, mapping);
        return result;
    }
    
    private void DFS(List<String> result, StringBuilder sb, int level, String digits, String[] mapping){
        if (sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        // CAREFUL! character minus a character can get a int
        String curDigits = mapping[digits.charAt(level) - '0'];
        
        for (int i = 0; i < curDigits.length(); i++){
            sb.append(curDigits.charAt(i));
            DFS(result, sb, level+1, digits, mapping);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}
