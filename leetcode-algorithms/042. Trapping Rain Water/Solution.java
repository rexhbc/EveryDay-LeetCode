/**
 * DP: keet track of left and right highest point
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        
        int[] leftHighest = new int[height.length];
        int[] rightHighest = new int[height.length];
        
        for (int i = 0; i < leftHighest.length; i++){
            if (i == 0){
                leftHighest[i] = height[i];
            } else {
                leftHighest[i] = Math.max(leftHighest[i-1], height[i]);
            }
        }
        
        for (int i = rightHighest.length - 1; i >= 0; i--){
            if (i == rightHighest.length - 1){
                rightHighest[i] = height[i];
            } else {
                rightHighest[i] = Math.max(rightHighest[i+1], height[i]);
            }
        }
        
        int result = 0;
        for (int i = 1; i < height.length - 1; i++){
            result += Math.min(leftHighest[i], rightHighest[i]) - height[i];
        }
        
        return result;
    }
}

/**
 * Two pointer: keet track of left and right highest point
 *              木桶原理
 * Time : O(N)
 * Space: O(1)
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        
        while (left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            if (leftMax <= rightMax){
                result += (leftMax - height[left]);
                left++;
            } else {
                result += (rightMax - height[right]);
                right--;
            }
        }
        return result;
    }
}


