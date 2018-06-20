/**
 * Brute force
 * Time : O(N^2)
 * Space: O(1)
 */
class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++){
            for (int j = 0; j < words.get(i).length(); j++){
                if (j >= words.size() || words.get(j).length() <= i || words.get(i).charAt(j) != words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        
        return true;
    }
}
