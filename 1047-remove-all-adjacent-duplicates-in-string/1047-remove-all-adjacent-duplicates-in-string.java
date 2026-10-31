class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty()){
                if(st.peek() == ch){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }

        return sb.reverse().toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna