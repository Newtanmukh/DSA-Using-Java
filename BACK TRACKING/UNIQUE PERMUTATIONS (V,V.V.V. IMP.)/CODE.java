
class Solution {
    
    List<String> list;
    
    public void dfs(char[] arr, int ind){
            
        if(ind == arr.length-1 && !list.contains(String.valueOf(arr))){
            list.add(String.valueOf(arr));
            return;
        }
        
        for(int i=ind; i<arr.length; i++){
            swap(arr, ind, i);
            dfs(arr, ind+1);
            swap(arr, ind, i);//this step is for reversing the first swap coz other recursion steps will use this
        }
    }
    
    public void swap(char[] arr, int ind1, int ind2){
        char x = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = x;
    }
    
    public List<String> find_permutation(String S) {
        list = new ArrayList<>();
        dfs(S.toCharArray(), 0);
        Collections.sort(list);
        return list;
    }
}