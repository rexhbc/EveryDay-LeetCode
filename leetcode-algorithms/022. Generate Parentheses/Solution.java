/**
 * Key: determine when you add '(' and ')'
 * Time : O(2^(2n)) since every level splits into two and
 *        there is 2n levels
 * Space: O(2N)
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(sb, n, 0, 0, result);
        return result;
    }
    
    private void generate(StringBuilder sb, int n, int left, int right, List<String> result){
        if (sb.length() == n*2){
            result.add(sb.toString());
            return;
        }
        
        if (left < n){
            sb.append('(');
            generate(sb, n, left+1, right, result);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if (right < left){
            sb.append(')');
            generate(sb, n, left, right+1, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
