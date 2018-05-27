/**
 * brute force since there is constant possibilities
 * Time : O(1)
 * Space: O(1) the call stack will not change number as the input
 *
 * BUG: when going back to previous level, added the lastest removed
 *      element first.
 */
class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> array = new ArrayList<>();
        
        for (int i : nums){
            array.add((double)i);
        }
        
        boolean[] res = new boolean[]{false};
        helper(array, res);
        
        return res[0];
    }
    
    private void helper(List<Double> array, boolean[] res){
        
        if (array.size() == 0){
            return;
        }
        if (array.size() == 1){
            if (Math.abs(array.get(0) - 24.0) < 0.001){
                res[0] = true;
                return;
            }
        }
        
        for (int i = 0; i < array.size(); i++){
            for (int j = 0; j < i; j++){
                double num1 = array.get(i);
                double num2 = array.get(j);
                
                List<Double> next = new ArrayList<>();
                next.add(num1+num2);
                next.add(num1-num2);
                next.add(num2-num1);
                next.add(num1*num2);
                
                if (Math.abs(num1) > 0.001) next.add(num2/num1);
                if (Math.abs(num2) > 0.001) next.add(num1/num2);
                
                // remove the two elements after the operations
                array.remove(i);
                array.remove(j);
                
                // add the new element to the array and do DFS
                for (Double d : next){
                    array.add(d);
                    helper(array, res);
                    array.remove(array.size()-1);
                }
                
                // needed to add back the elements to go back to previous level
                // THIS NEEDED TO BE REVERSE ORDER
                array.add(j, num2);
                array.add(i, num1);
            }
        }
    }
}
