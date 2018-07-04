/**
 * Using hashMap
 * Time : O(N+M)
 * Space: O(N or M)
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1){
            Integer count = map.get(i);
            if (count == null){
                map.put(i, 1);
            } else {
                map.put(i, count+1);
            }
        }
        
        for (int i : nums2){
            Integer count = map.get(i);
            if (count != null && count >= 1){
                list.add(i);
                map.put(i, count - 1);
            }
        }
        
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}
