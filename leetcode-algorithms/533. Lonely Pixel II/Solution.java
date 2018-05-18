/*
 * Time: O(M*N)
 * Space: (M+N)
 */
class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0 || N < 0){
            return 0;
        }
        
        Map<String, Integer> map = new HashMap<>();
        int[] bColCount = new int[picture[0].length];
        
        for (int i = 0; i < picture.length; i++){
            
            char[] cur = new char[picture[i].length];
            int countB = 0;
            for (int j = 0; j < picture[i].length; j++){
                if (picture[i][j] == 'B'){
                    bColCount[j]++;
                    countB++;
                }
                cur[j] = picture[i][j];
            }
            
            if (countB == N){
                String s = new String(cur);
                map.put(s, map.getOrDefault(s, 0)+1);
            }
        }
        
        int result = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            
            if (entry.getValue() == N){
                char[] array = entry.getKey().toCharArray();
                for (int i = 0; i < array.length; i++){
                    if (array[i] == 'B' && bColCount[i] == N){
                        result += entry.getValue();
                    }
                }
            }
        }
        
        return result;
    }
}


