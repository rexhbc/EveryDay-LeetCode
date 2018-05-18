/**
 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1){
            return;
        }
        
        boolean isMore = true;
        for (int i = 1; i < nums.length; i++){
            if (isMore){
                if (nums[i] < nums[i-1]) swap(nums, i, i-1);
            } else {
                if (nums[i] > nums[i-1]) swap(nums, i, i-1);
            }
            
            isMore = !isMore;
        }
    }
    
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
