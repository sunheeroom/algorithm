class Solution {
    public int majorityElement(int[] nums) {
        int major = 0;

        List<Integer> collect = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());

        Map<Integer, Long> map =Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> result = map.entrySet().stream()
            .filter(entry -> entry.getValue() > (nums.length / 2)).map(java.util.Map.Entry::getKey)
            .collect(Collectors.toList());

        return result.get(0);
    }


}