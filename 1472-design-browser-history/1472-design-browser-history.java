class BrowserHistory {
    Deque<String> currHistory;
    Deque<String> forwardHistory;

    public BrowserHistory(String homepage) {
        currHistory = new ArrayDeque<>();
        forwardHistory = new ArrayDeque<>();

        currHistory.push(homepage);
    }
    
    public void visit(String url) {
        currHistory.push(url);
        forwardHistory = new ArrayDeque<>();
        
    }
    
    public String back(int steps) {
        while(steps > 0){
            if(currHistory.size() > 1){
                String backTab = currHistory.pop();
                forwardHistory.push(backTab);
            }else{
                break;
            }
            steps --;
        }
        return currHistory.peek();
        
    }
    
    public String forward(int steps) {
        while(steps > 0){
            if(forwardHistory.size() > 0){
                String forwardTab = forwardHistory.pop();
                currHistory.push(forwardTab);
            }else{
                break;
            }
            steps --;
        }
        return currHistory.peek();
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna