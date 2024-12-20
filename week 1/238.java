//Product of Array Except Self
class Solution {
    public int[] productExceptSelf(int[] nums) {
     int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
        // Initialize the first element of left array
        left[0] = 1;
        // Fill the left array
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
          // Initialize the last element of right array
        right[n - 1] = 1;
        // Fill the right array
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Calculate the result by multiplying left and right arrays
        for (int i = 0; i < n; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;        
    }
}
