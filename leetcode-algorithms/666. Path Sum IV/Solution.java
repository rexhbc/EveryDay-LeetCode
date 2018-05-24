
/**
 * build the tree using hashMap(positon, value)
 * Time : O(N)
 * Space: O(H) -> O(N)
 */
class Solution {
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        Map<Integer, Integer> treeMap = constructTree(nums);
        
        int[] result = new int[]{0};
        
        DFS(result, nums[0]/10, 0, treeMap);
        
        return result[0];
    }
    
    private Map<Integer, Integer> constructTree(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i: nums){
            int key = i / 10;
            int value = i % 10;
            map.put(key, value);
        }
        
        return map;
    }
    
    private void DFS(int[] result, int curNode, int preSum, Map<Integer, Integer> treeMap){        
        int level = curNode / 10 + 1;
        int position = curNode % 10;
        int leftNode = level * 10 + 2 * position - 1;
        int rightNode = level * 10 + 2 * position;
        int curSum = preSum + treeMap.get(curNode);
        
        // when it is the leafNode, we should add the path to the result
        if (!treeMap.containsKey(leftNode) && !treeMap.containsKey(rightNode)){
            result[0] += curSum;
            return;
        }
        
        if (treeMap.containsKey(leftNode)){
            DFS(result, leftNode, curSum, treeMap);
        }
        if (treeMap.containsKey(rightNode)){
            DFS(result, rightNode, curSum, treeMap);
        }
        
    }
}
