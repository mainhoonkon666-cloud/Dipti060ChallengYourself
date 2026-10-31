class Solution {
    public int longestValidParentheses(String s) {
        int open  = 0;
        int close = 0;
        int MaxLen = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                open++;
            }
            else{
                close++;
            }

            if(close > open){
                open = 0;
                close = 0;
            }
            else if(open == close){
                MaxLen = Math.max(MaxLen, 2*close);
            }
        }

        open = 0;
        close = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }
            else{
                close++;
            }
            if(open > close){
                open = 0;
                close = 0;
            }
            else if(open == close){
                MaxLen = Math.max(MaxLen, 2*close);
            }
        }

        return MaxLen;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna