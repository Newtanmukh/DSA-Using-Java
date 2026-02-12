
//problem desc; https://www.geeksforgeeks.org/problems/find-patterns0606/1
int numberOfSubsequences(String S, String W) {
    int i=0 , j=0;

    int count=0;

    char str[] = S.toCharArray();

    while(j<S.length()){

        if(W.charAt(i) == str[j]){

            str[j] = '#';

            i++;

        }

        if(i==W.length()){

            count++;

            i=0;

            j=-1;

        }

        j++;

    }

    return count;

}