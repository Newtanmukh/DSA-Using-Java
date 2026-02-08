import java.util.Arrays;
import java.util.Comparator;


//problem statement: https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1

class CODE {
    public String findLargest(int[] nums) {
        // code here

        Integer[] arr = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);


        Arrays.sort(arr, new Comparator<Integer>(){

            @Override
            public int compare(Integer lhs, Integer rhs){
                String lString = lhs + "" + rhs;
                String rString = rhs + "" + lhs;

                return -lString.compareTo(rString);
            }

        });

        StringBuilder sb = new StringBuilder();
        if (arr[0] == 0) return "0";

        for(int a: arr){
            sb.append(a);
        }



        return sb.toString();
    }
}