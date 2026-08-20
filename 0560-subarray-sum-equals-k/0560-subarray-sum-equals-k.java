class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += nums[i];
            int target = sum - k;

            if(map.containsKey(target)){
                count += map.get(target);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}