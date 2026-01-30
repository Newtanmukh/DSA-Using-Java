/*Complete the function below*/
class GfG {
    public static int maxCoins(int arr[], int n) {
        // int n = arr.length;
        int i = 0;
        int j = n-1;

        int turn = 0;

        int x = 0;
        int y = 0;

        while(i <= j){
            if(turn%2==0){
                if(arr[i]>=arr[j]){
                    x += arr[i];
                    i++;
                }else{
                    x += arr[j];
                    j--;
                }
            }else{
                if(arr[i]>=arr[j]){
                    y += arr[i];
                    i++;
                }else{
                    y += arr[j];
                    j--;
                }
            }

            turn++;
        }

        return x;
    }
}