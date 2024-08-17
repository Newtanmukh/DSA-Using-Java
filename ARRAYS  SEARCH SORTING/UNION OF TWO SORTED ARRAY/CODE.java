 public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
    //   TreeSet<Integer> result = new TreeSet<>();
        
    //     for(int i : arr1) result.add(i);
    //     for(int j : arr2) result.add(j);
        
    //     return new ArrayList<>(result);
    
        // add your code here
        ArrayList<Integer> li=new ArrayList<>();
        int i=0,j=0;
        while(i<n && j<m){
            int x=arr1[i],y=arr2[j];
            if(x==y){
                li.add(x);
                while(i<n && arr1[i]==x) i++;
                while(j<m && arr2[j]==y) j++;
            }
            else if(x<y){
                li.add(x);
                while(i<n && arr1[i]==x) i++;
            }else{
                li.add(y);
                while(j<m && arr2[j]==y) j++;
            }
        }
        while(i<n){
            int x=arr1[i];
            li.add(x);
            while(i<n && arr1[i]==x) i++;
        }
        while(j<m){
            int y=arr2[j];
            li.add(y);
            while(j<m && arr2[j]==y) j++;
        }
        return li;
    }