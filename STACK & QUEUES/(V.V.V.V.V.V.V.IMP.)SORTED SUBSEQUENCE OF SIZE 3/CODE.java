class Solution {

    //Solve it using this
    //first smaller elemnt to the left
    //first greater element to the right
    public List<Integer> find3Numbers(int[] arr) {
        // code here

        int n = arr.length;
        int[] smallerToLeft = new int[n];
        int[] greaterToRight = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--){

            while(stack.size() > 0 && stack.peek() <= arr[i])
                stack.pop();

            if(stack.isEmpty()){
                greaterToRight[i] = -1;
            }else{
                greaterToRight[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        stack = new Stack<>();

        for(int i=0; i<n; i++){

            while(stack.size() > 0 && stack.peek()>=arr[i])
                stack.pop();

            if(stack.isEmpty()){
                smallerToLeft[i] = -1;
            }else{
                smallerToLeft[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        for(int i=0; i<n; i++){
            if(smallerToLeft[i]!=-1 && greaterToRight[i]!=-1){
                List<Integer> ans = new ArrayList<>();
                ans.add(smallerToLeft[i]);
                ans.add(arr[i]);
                ans.add(greaterToRight[i]);
                return ans;
            }
        }

        return new ArrayList<>();
    }
}