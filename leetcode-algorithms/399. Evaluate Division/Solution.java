/**
 * BFS: used hashmap to store the relation between each node and also values
 * Time : O(V+E) 
 * Space: O(V+E)
 */
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, List<Double>> vMap = new HashMap<>();
        
        for (int i = 0; i < equations.length; i++){
            String[] equation = equations[i];
            
            // creating the list for each node in the graph
            if (!map.containsKey(equation[0])){
                map.put(equation[0], new ArrayList<>());
                vMap.put(equation[0], new ArrayList<>());
            }
            
            if (!map.containsKey(equation[1])){
                map.put(equation[1], new ArrayList<>());
                vMap.put(equation[1], new ArrayList<>());
            }
            
            // store the values to construct the map
            map.get(equation[0]).add(equation[1]);
            vMap.get(equation[0]).add(values[i]);
            
            map.get(equation[1]).add(equation[0]);
            vMap.get(equation[1]).add(1/values[i]);
        }
        
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++){
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], map, vMap, new HashSet<String>(), 1.0);
        }
        
        return result;
    }
    
    private double dfs(String start, String end, Map<String, List<String>> pairs, Map<String, List<Double>> values, Set<String> set, double value) {
        
        // base case
        // when the start already been visited
        if (set.contains(start)) return -1.0;
        
        // if there is valid start stored in the map
        if (!pairs.containsKey(start)) return -1.0;
        
        // when start is the end, we can return the values
        if (start.equals(end)) return value;
        
        // in the current level, you should add the stage to the visited set
        set.add(start);
        
        List<String> strList = pairs.get(start);
        List<Double> valueList = values.get(start);
        for (int i = 0; i < strList.size(); i++) {
            double tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
            if (tmp != -1.0) {
                return tmp;
            }
        }
        return -1.0;
    }
}
