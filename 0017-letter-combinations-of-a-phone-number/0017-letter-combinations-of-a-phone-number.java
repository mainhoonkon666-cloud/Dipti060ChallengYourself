class Solution {
    static void solve(String digits, int index, String[] mapping, List<String> result,StringBuilder output){
        if(index >= digits.length()){
            result.add(output.toString());
            return;
        }

        int value = digits.charAt(index) - '0';
        String mappedString = mapping[value];

        for(int i = 0; i < mappedString.length(); i++){
            output.append(mappedString.charAt(i));
            solve(digits, index + 1, mapping, result, output);

            //backtracking step
            output.deleteCharAt(output.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        int index = 0;
        StringBuilder output = new StringBuilder();
        solve(digits, index, mapping, result, output);
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna