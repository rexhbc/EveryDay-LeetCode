/**
 * BFS: 每个string的变化 都是另一条路径 然后求最短路径
 * Time : O((M*N)!)
 * Space: O((M*N)!)
 */
class Solution {
    
    public int slidingPuzzle(int[][] board) {
        Set<String> set = new HashSet<>();
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        //add all the number and represent as a string
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
            }
        }
        
        String s = sb.toString();
        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast(s);
        set.add(s);
        int[] distance = new int[]{1,-1,3,-3};
        int result = 0;
        
        while (!queue.isEmpty()){
            
            int size = queue.size();
            for (int index = 0; index < size; index++){
                String cur = queue.pollFirst();
                
                // when the current state is the final state
                if (cur.equals(target)) {
                    return result;
                }
                int i = cur.indexOf('0');// ??? why locate 0???
                for (int k = 0; k < 4; k++){
                    int j = i + distance[k]; // the swapping index
                
                    if (j < 0 || j > 5 || i == 2 && j == 3 || i == 3 && j == 2){
                        continue; // skip all the invalid swap
                    }
                    char[] ch = cur.toCharArray();
                    
                    // swap them
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                    
                    // construct the new string 
                    String next = new String(ch);
                    
                    // avoid duplicate
                    if (set.add(next)){
                        queue.offerLast(next);
                    }
                }
            }
            
            result++;
        }
        
        return -1;
    }
    

}
