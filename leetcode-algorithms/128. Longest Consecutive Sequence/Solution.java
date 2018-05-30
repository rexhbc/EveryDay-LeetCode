/**
 * Sorting 
 * Time : O(NlogN)
 * Space: O(1)
 * Bug: didnt consider the case when two elements are euqal
 *      it should keep going since it is a sequence.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        
        int globalMax = 1;
        int localMax = 1;
        
        for (int i = 1; i < nums.length; i++){
            
            // when they are equal. we should keep going
            if (nums[i] == nums[i-1]){
                continue;
            }
            else if (nums[i] == nums[i-1] + 1){
                localMax++;
            } else {
                localMax = 1;
            }
            
            globalMax = Math.max(globalMax, localMax);
        }
        
        return globalMax;
    }
}

/**
 * Hashtable 
 * Time : O(N)
 * Space: O(N)
 * Optimize: since we are counting from small to large, once we find num-1 existed,
 *           meaning we already counted. so therefore, it will be O(N+N)->O(N)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        // since it is a set, we dont have any duplicates
        for (int num : nums){
            set.add(num);
        }
        
        int globalMax = 0;
        
        // for each number, check their consecutives
        for (int num : set){
            
            // when contains num-1, meaning it is already counted, 
            // so no need to count again
            if (!set.contains(num-1)){
                int current = num;
                int localLength = 1;
                while (set.contains(current+1)){
                    current++;
                    localLength++;
                }
            
                globalMax = Math.max(globalMax, localLength);
            }
        }
        
        return globalMax;
    }
}


