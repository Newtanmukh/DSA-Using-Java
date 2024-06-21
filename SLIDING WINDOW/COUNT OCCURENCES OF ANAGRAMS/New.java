  int search(String pat, String txt) {
        int[] patArray = new int[26];
        int[] txtArray = new int[26];
        
        Arrays.fill(patArray, 0);
        Arrays.fill(txtArray, 0);
        
        int k = pat.length();
        
        for(int i=0; i<k; i++){
            int patIndex = pat.charAt(i) - 97;
            patArray[patIndex]++;
            
            if(i!=k-1)
            {
                int txtIndex =txt.charAt(i) - 97;
                txtArray[txtIndex]++;
            }
        }
        
        int count = 0;
        
        for(int i=k-1; i<txt.length(); i++){
            int txtIndex = txt.charAt(i) - 97;
            txtArray[txtIndex]++;
            
            if(Arrays.equals(txtArray, patArray)){
                count++;
            }
            
            int removeTxtIndex = txt.charAt(i-k+1) - 97;
            txtArray[removeTxtIndex]--;
        }
        
        return count;
        
    }