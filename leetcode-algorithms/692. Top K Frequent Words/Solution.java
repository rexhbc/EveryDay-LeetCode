/**
 * Time: O(N + NlogK + KlogK) -> O(NlogK)
 * Space: O(N+K)
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0){
            return result;
        }
        
        Map<String, Integer> map = getFrequency(words);
        
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2){
                if (m1.getValue() == m2.getValue()){
                    return m2.getKey().compareTo(m1.getKey());
                } 
                return m1.getValue() < m2.getValue() ? -1 : 1;
            }
        });
        
        for (Map.Entry<String, Integer> entry :  map.entrySet()){
            if (minHeap.size() < k ){
                 minHeap.offer(entry);
            }
            // when there is k entries
            else if(entry.getValue() > minHeap.peek().getValue() || 
                    (entry.getValue() == minHeap.peek().getValue() && entry.getKey().compareTo(minHeap.peek().getKey()) < 0)){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        }
        
        Collections.reverse(result);
        return result;
    }
    
    private Map<String, Integer> getFrequency(String[] words){
        Map<String, Integer> map = new HashMap<>();
        
        for (String s: words){
            Integer count = map.get(s);
            if (count == null){
                map.put(s, 1);
            } else {
                map.put(s, count+1);
            }
        }
        return map;
    }
}
