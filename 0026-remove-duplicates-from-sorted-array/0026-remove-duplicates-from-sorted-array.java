class Solution {
    public int removeDuplicates(int[] nums) {
        java.util.Set<Integer> numSet = Arrays.stream(nums)
                                        .boxed()
                                        .collect(Collectors.toCollection(TreeSet::new));

        List<Integer> list = numSet.stream().collect(Collectors.toList());
        for(int i=0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return numSet.size();
    }
}