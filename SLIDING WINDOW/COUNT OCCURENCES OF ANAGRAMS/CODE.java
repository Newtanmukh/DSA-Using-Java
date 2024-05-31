class Solution {

    int search(String pat, String txt) {
       int[] patFreq = new int[26];
	   int[] txtFreq = new int[26];
	   Arrays.fill(patFreq, 0);
	   Arrays.fill(txtFreq, 0);
	   
	   int n = txt.length();
	   
	   int k = pat.length();
	   
	   for(int i=0; i<k; i++){
	       int index = pat.charAt(i) - 97;
	       patFreq[index]++; 
	       
	       index = txt.charAt(i) - 97;
	       txtFreq[index]++;
	   }
	   
	   int count = 0;
	   
	   if(Arrays.equals(txtFreq, patFreq)){
	       count++;
	   }
	   
	   for(int i=1; i<n-k+1; i++){
	       int removeIndex = txt.charAt(i-1) - 97;
	       int addIndex = txt.charAt(i+k-1) - 97;
	       txtFreq[removeIndex]--;
	       txtFreq[addIndex]++;
	       
	       if(Arrays.equals(patFreq, txtFreq)){
	           count++;
	       }
	   }
	   
	   return count;
    }
}