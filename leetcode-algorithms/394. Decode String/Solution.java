/** 
 * used stacks to store the info
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<String> strings = new ArrayDeque<>();
        char[] array = s.toCharArray();
        int index = 0;
        String cur = "";
        while (index < s.length()){
            // if it is a digit
            if (array[index] >= '0' && array[index] <= '9'){
                int start = index;
                while (index < s.length() && array[index] != '['){
                    index++;
                }
                
                int count = Integer.parseInt(s.substring(start, index));
                counts.offerFirst(count);
            } else if (array[index] == '['){
                strings.offerFirst(cur);
                cur = "";
                index++;
            } else if (array[index] == ']'){
                String str = strings.pollFirst();
                int times = counts.pollFirst();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < times; i++){
                    sb.append(cur);
                }
                
                cur = str + sb.toString();
                index++;
            } else {
                cur = cur + s.charAt(index++);
            }
        }
        
        return cur;
    }
}
