
//problem desc: https://www.geeksforgeeks.org/problems/next-greater-element/1
class Solution {
    public ArrayList<Integer> nextGreater(int[] a) {
        // code here
        int n = a.length;
        int[] dp = new int[2*n];
        Arrays.fill(dp, -1);

        int[] arr = new int[2*n];

        for(int i=0; i<n; i++){
            arr[i] = a[i];
            arr[i+n] = a[i];
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=2*n-1; i>=0; i--){
            int ele = arr[i];


            //from top to bottom elements are arranged in ascending order.
            //so remove ell elements which are smaller than ele.
            while(!stack.isEmpty() &&  stack.peek() <= ele){
                stack.pop();
            }

            if(stack.isEmpty()){
                dp[i] = -1;
            }else{
                dp[i] = stack.peek();
            }

            stack.push(ele);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(dp[i]);
        }

        return list;
    }
}