/**
 * Using binary search
 * Time : O(log(M+N))
 * Space: O(logK) -> K is (M+N)/2
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = (nums1.length + nums2.length + 1) / 2;
        int r = (nums1.length + nums2.length + 2) / 2;
        
        return (findMedian(nums1,0,nums2,0,l) + findMedian(nums1,0,nums2,0,r)) / 2.0;
    }
    
    private double findMedian(int[] a, int aLeft, int[] b, int bLeft, int k){
        // base case
        if (aLeft > a.length - 1){
            return b[bLeft + k - 1];
        }
        if (bLeft > b.length - 1){
            return a[aLeft + k - 1];
        }
        
        if (k == 1){
            return Math.min(a[aLeft], b[bLeft]);
        }
        
        int aCur = Integer.MAX_VALUE;
        int bCur = Integer.MAX_VALUE;
        
        if (aLeft + k/2  - 1 < a.length){
            aCur = a[aLeft + k/2 - 1];
        }
        
        if (bLeft + k/2 - 1 < b.length){
            bCur = b[bLeft + k/2 - 1];
        }
        
        if (aCur < bCur){
            return findMedian(a, aLeft + k/2, b, bLeft, k - k/2);
        } else {
            return findMedian(a, aLeft, b, bLeft + k/2, k - k/2);
        }
    }
}
