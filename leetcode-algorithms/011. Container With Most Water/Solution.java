// /**
//  * Brute force -> time limit exceeded
//  * Time : O(N^2)
//  * Space: O(1)
//  */
// class Solution {
//     public int maxArea(int[] height) {
//         int globalMax = 0;
//         for (int i = 0; i < height.length; i++){
//             for (int j = i + 1; j < height.length; j++){
//                 globalMax = Math.max(globalMax, (j-i)*Math.min(height[i],height[j]));
//             } 
//         }
        
//         return globalMax;
//     }
// }

/**
 * Two Pointer, 木桶原理， 谁短移谁
 * Time : O(N)
 * Space: O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int globalMax = 0;
        int left = 0;
        int right = height.length-1;
        
        while (left < right){
            int leftHeight = height[left];
            int rightHeight = height[right];
            globalMax = Math.max(globalMax, (right-left)*Math.min(leftHeight, rightHeight));
            
            if (leftHeight <= rightHeight){
                left++;
            } else {
                right--;
            }
        }
        
        return globalMax;
    }
}
