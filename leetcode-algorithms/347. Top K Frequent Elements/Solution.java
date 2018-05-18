/**
 * Time: O(N + NlogK + KlogK) -> O(NlogK)
 * Space: O(N+K)
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        
        Map<Integer, Integer> map = countFrequency(nums);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                if (map.get(i1) == map.get(i2)){
                    return 0;
                }
                
                return map.get(i1) < map.get(i2) ? -1:1;
            }
        });
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (minHeap.size() < k){
                minHeap.offer(entry.getKey());
            } else if (entry.getValue() >= map.get(minHeap.peek())){
                minHeap.poll();
                minHeap.offer(entry.getKey());
            }
        }
        
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        
        Collections.reverse(result);
        return result;
    }
    
    private Map<Integer, Integer> countFrequency(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums){
            Integer count = map.get(i);
            if (count == null){
                map.put(i, 1);
            } else {
                map.put(i, count+1);
            }
        }
        
        return map;
    }
}


