/**
 * same concept as "google love i"
 * Time : O(N)
 * Space: O(1)
 * Bug: when k is larger than the array length, it should be shorten
 */
class Solution {
    public void rotate(int[] nums, int k) {
        // BE CAREFUL WITH K
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] array, int left, int right){
        while (left < right){
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}
