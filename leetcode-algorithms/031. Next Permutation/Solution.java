/**
 * Key  : find the first decreasing number from the end
 * Time : O(N)
 * Space: O(1)
 * Bug  : think through the next permutation first before doing the problem!
 */

class Solution {
    public void nextPermutation(int[] nums) {
        
        // find the first decreasing number from the end
        int pos = nums.length - 2;
        while (pos >= 0 && nums[pos] >= nums[pos+1]){
            pos--;
        }
        
        if (pos >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[pos]) {
                j--;
            }
            swap(nums, pos, j);
        }
        reverse(nums,pos + 1, nums.length-1);
    }
    
    private void reverse(int[] array, int i, int j){
        while (i < j){
            swap(array, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
