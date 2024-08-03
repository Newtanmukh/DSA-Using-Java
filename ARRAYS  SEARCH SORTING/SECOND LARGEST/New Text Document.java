class Solution {
    public int print2largest(List<Integer> arr) {
        int secondLargest = -1;
        int largest = arr.get(0);
        
        for(int num: arr){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            }else if(largest > num && num > secondLargest){
                secondLargest = num;
            }
        }
        
        return secondLargest;
    }
}