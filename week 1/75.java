//Sort Colors
class Solution {
    public void sortColors(int[] nums) {
     int[] freq = new int[3];
        for (int num : nums)
            freq[num]++;

        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                nums[idx] = i;
                idx++;
                freq[i]--;
            }
        }   
    }
}
