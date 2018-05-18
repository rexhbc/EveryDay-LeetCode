/**
 * Time: O(Klogk)
 * Space: O(M*N+K)
 */

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        final int rows = nums1.length;
        final int cols = nums2.length;
        
        if (nums1 == null || nums1.length == 0 || nums2 ==null || nums2.length == 0 || k <= 0){
            return result;
        }
        
        
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>(){
            public int compare(Cell c1, Cell c2){
                if (c1.value == c2.value) return 0;
                
                return c1.value < c2.value ? -1:1;
            }
        });
        
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        visited[0][0] = true;
        minHeap.offer(new Cell(0,0,nums1[0]+nums2[0]));
        
        // case to deal with when k is larger than the max number of pairs
        if (k > rows*cols){
            k = rows*cols;
        }
        
        while (k > 0){
            Cell cur = minHeap.poll();
            result.add(new int[]{nums1[cur.i], nums2[cur.j]});
            
            if (cur.i + 1 < rows && ! visited[cur.i+1][cur.j]){
                minHeap.offer(new Cell(cur.i+1, cur.j, nums1[cur.i+1] + nums2[cur.j]));
                visited[cur.i+1][cur.j] = true;
            }
            
            if (cur.j + 1 < cols && ! visited[cur.i][cur.j+1]){
                minHeap.offer(new Cell(cur.i, cur.j+1, nums1[cur.i] + nums2[cur.j+1]));
                visited[cur.i][cur.j+1] = true;
            }
            
            k--;
        }
        
        return result;
    }
    
    static class Cell{
        int i;
        int j;
        int value;
        Cell(int i, int j, int value){
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}


