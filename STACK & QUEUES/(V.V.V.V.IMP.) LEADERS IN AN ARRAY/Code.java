class Solution {

    // just find the next greater element.
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[n];

        for(int i = n-1; i>=0; i--){
            while(stack.size() > 0 && stack.peek() <= arr[i])
                stack.pop();

            if(stack.isEmpty()){
                dp[i] = -1;
            }else{
                dp[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(dp[i]==-1){
                list.add(arr[i]);
            }
        }

        return list;

    }
}
