// /**
//  * Brute Force
//  * Time : O(N^2)
//  * Space: O(1)
//  */
// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int[] result = new int[temperatures.length];
        
//         for (int i = 0; i < temperatures.length; i++){
//             for (int j = i+1; j < temperatures.length; j++){
//                 if (temperatures[j] > temperatures[i]){
//                     result[i] = j-i;
//                     break;
//                 }
//             }
//         }
        
//         return result;
//     }
// }

/**
 * Using stack to store the index
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        
        // stack stroing the index
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]){
                result[stack.peekFirst()] = i - stack.peekFirst();
                stack.pollFirst();
            }
            
            stack.offerFirst(i);
        }
        
        return result;
    }
}
