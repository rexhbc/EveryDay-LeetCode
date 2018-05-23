/**
 * for each element in nums1, find the element in nums2, and then
 * find the next greater element;
 *
 * Time : O(N^2)
 * Space: O(1)
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++){
            result[i] = -1;
            boolean found = false;
            for (int j = 0; j < nums2.length; j++){
                if (found && nums2[j] > nums1[i]){
                    result[i] = nums2[j];
                    break;
                }
                if (nums2[j] == nums1[i]){
                    found = true;
                }
            }
        }
        
        return result;
    }
}

/**
 * using Stack and hashMap
 *
 * Time : O(N^2)
 * Space: O(1)
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        // first is the number, second the next greatest number
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums2.length; i++){
            map.put(nums2[i], -1);
        }
        
        for (int i = 0; i < nums2.length; i++){
            while (!stack.isEmpty() && nums2[i] > stack.peekFirst()){
                map.put(stack.pollFirst(), nums2[i]);
            }
            stack.offerFirst(nums2[i]);
        }
        
        for (int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
