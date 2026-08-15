class Solution {
    static void solve(int[]candidates, int target,int index, List<List<Integer>> ans, List<Integer> output, int count,int k){
        if(count > k){
            return;
        }

        if(count == k && target == 0){
            ans.add(new ArrayList(output));
            return;
        }
        if(index >= candidates.length){
            return;
        }
        if(target < 0){
            return;
        }
        output.add(candidates[index]);
        solve(candidates,target - candidates[index], index+1, ans, output, count+1, k);

        output.remove(output.size() - 1);

        while(index+1 < candidates.length && candidates[index] == candidates[index+1]){
            index ++;
        }

        solve(candidates, target, index + 1, ans, output,count,k);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        // Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        int target = n;
        int count = 0;
        solve(candidates, target, index, ans, output, count, k);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna