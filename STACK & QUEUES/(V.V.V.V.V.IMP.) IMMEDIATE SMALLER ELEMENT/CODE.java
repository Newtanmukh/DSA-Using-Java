
//problem link : https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here


        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i>=0; i--){
            while(stack.size()>0 && stack.peek()>=arr[i])
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
            list.add(dp[i]);
        }

        return list;
    }
}