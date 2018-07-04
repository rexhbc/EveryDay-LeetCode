/**
 * use hashmap to store and also "stack"
 * Time : O(NLogN) due to sorting
 * Space: O(N)
 */
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new HashMap<>();
        
        for (int i = 0; i < position.length; i++){
            map.put(position[i], (double)(target - position[i])/speed[i]);
        }
        
        Arrays.sort(position);
        
        int result = 0;
        int i = position.length - 1;
        
        while (i >= 0){
            int cur = i; // pop one
            double curTime = map.get(position[i]);
            result++;
            while (i >= 0 && map.get(position[i]) <= curTime){
                i--;
            }
        }
        
        return result;
    }
}
