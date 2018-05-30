/**
 * build a array contains all possible number,
 * then find all the permutations and check whether it
 * will be satisfying the condition.
 * SWAP-SWAP!!!!
 * Time : O(N!)
 * Space: O(N)
 */
class Solution {
    public int countArrangement(int N) {
        int[] result = new int[]{0};
        
        int[] array = new int[N+1];
        
        for (int i = 1; i < array.length; i++){
            array[i] = i;
        }
        
        DFS(array, 1, result);
        return result[0];
    }
    
    private void DFS(int[] array, int level, int[] result){
        // base case
        if (level == array.length){
            if (array[level-1] % (level-1) == 0 || (level-1) % array[level-1] == 0){
                result[0]++;
            }
            return;
        }
        
        // recursive rule
        for (int i = level; i < array.length; i++){
            swap(array, i, level);
            if (array[level] % level == 0 || level % array[level] == 0){
                DFS(array, level+1, result);
            }
            swap(array, i, level);
        }
    }
    
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
