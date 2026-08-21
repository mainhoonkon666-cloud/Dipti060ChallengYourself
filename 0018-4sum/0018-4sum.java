import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i < n - 3; i++){

            // skip duplicate i
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }


            for(int j = i + 1; j < n - 2; j++){

                // skip duplicate j
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }


                int left = j + 1;
                int right = n - 1;


                while(left < right){

                    long sum = (long)nums[i] 
                             + nums[j] 
                             + nums[left] 
                             + nums[right];


                    if(sum < target){
                        left++;
                    }

                    else if(sum > target){
                        right--;
                    }

                    else{

                        ans.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));


                        left++;
                        right--;


                        // skip duplicate left
                        while(left < right &&
                              nums[left] == nums[left-1]){
                            left++;
                        }


                        // skip duplicate right
                        while(left < right &&
                              nums[right] == nums[right+1]){
                            right--;
                        }
                    }
                }
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna