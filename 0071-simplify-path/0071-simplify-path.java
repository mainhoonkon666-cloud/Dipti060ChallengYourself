class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();

        String[] parts = path.split("/");
        for(String part:parts){
            if(part.isEmpty()){
                continue;
            }
            if(part.equals(".")){
                continue;
            }
            if(part.equals("..") && st.isEmpty()){
                continue;
            }
            if(part.equals("..") && !st.isEmpty()){
                st.pop();
            }
            else{
                st.push(part);
            }
        }
        if(st.isEmpty()){
            return "/";
        }
        else{
            StringBuilder str = new StringBuilder();

            while(!st.isEmpty()){
                str.append("/");
                str.append(st.removeLast());
            }

            return str.toString();
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna