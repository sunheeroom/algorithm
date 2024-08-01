class Solution {
    public void rotate(int[] nums, int k) {
        int move = k % nums.length; 
        int[] temp = new int[move];

        for(int i= nums.length - move, t=0; i < nums.length && t < move; i++, t++) {
            temp[t] = nums[i];
        }

        for(int i=nums.length - 1; i >= 0; i--) {
            if ( i >= move) { 
                nums[i] = nums[i-move];
            } else {
                nums[i] = temp[i];
            }
        }
    }
}