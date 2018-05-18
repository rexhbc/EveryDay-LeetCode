/**
 * Time: O(KlogK)
 * Space: O(MN+K)
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return Integer.MAX_VALUE;
        }
        
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>(){
            public int compare(Cell c1, Cell c2){
                if(c1.value == c2.value){
                    return 0;
                }
                
                return c1.value < c2.value? -1:1;
            }
        });
        
        boolean[][] visited = new boolean[rows][cols];
        minHeap.offer(new Cell(0,0,matrix[0][0]));
        visited[0][0] = true;
        
        for (int i = 0; i < k - 1; i++){
            Cell cur = minHeap.poll();
            if (cur.row + 1 < rows && !visited[cur.row+1][cur.col]){
                minHeap.offer(new Cell(cur.row+1, cur.col, matrix[cur.row+1][cur.col]));
                visited[cur.row+1][cur.col] = true;
            }
            
            if (cur.col + 1 < cols && !visited[cur.row][cur.col+1]){
                minHeap.offer(new Cell(cur.row, cur.col+1, matrix[cur.row][cur.col+1]));
                visited[cur.row][cur.col+1] = true;
            }
        }
        
        return minHeap.peek().value;
    }
    
    static class Cell{
        int row;
        int col;
        int value;
        
        Cell(int row, int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}


