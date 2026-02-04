class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {

        ArrayList<Integer> ans = new ArrayList<>();

        for(int[] arr: mat){
            ans = new ArrayList<>(mergeArrays(ans, arr));
        }

        return ans;
    }

    public ArrayList<Integer> mergeArrays(ArrayList<Integer> list, int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();

        int n = list.size();
        int m = arr.length;

        int i = 0;
        int j = 0;

        while(i<n && j<m){
            int one = list.get(i);
            int two = arr[j];

            if(one<two){
                ans.add(one);
                i++;
            }else{
                ans.add(two);
                j++;
            }
        }

        while(i<n){
            ans.add(list.get(i));
            i++;
        }

        while(j<m){
            ans.add(arr[j]);
            j++;
        }

        return ans;
    }
}