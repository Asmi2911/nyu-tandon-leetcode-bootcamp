//Two Sum II - Input Array Is Sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = numbers.length;
        int result[] = new int[2];
        
        for (int i = 0; i < n; i++) {
            int complement = target - numbers[i];
            
            if (map.containsKey(complement)) {
                result[0] = map.get(complement) + 1;  // Index of the complement (1-based)
                result[1] = i + 1;  // Current index (1-based)
                return result;
            }
            
            map.put(numbers[i], i);  // Store the number and its index
        }
        
        return result;  // Return the result
    }
}