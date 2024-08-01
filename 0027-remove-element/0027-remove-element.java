class Solution {
    public int removeElement(int[] nums, int val) {
        int result = 0;
        Queue<Integer> vacant = new LinkedList<>();    // 제거한 위치
        int count = 0;

        for(int i=0; i < nums.length; i++) {
            if ( nums[i] == val ) {
                vacant.add(i);
            } else {
                count++;
                if (vacant.size() > 0) {
                    nums[vacant.poll()] = nums[i];
                    vacant.add(i);
                }
            }
        }
        return count;
    }
}