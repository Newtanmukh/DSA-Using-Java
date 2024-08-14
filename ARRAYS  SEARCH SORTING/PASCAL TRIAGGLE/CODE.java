class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int numRows) {
      
    ArrayList<ArrayList<Long>> list = new ArrayList<>();
    
    // Initialize the first row
    ArrayList<Long> firstRow = new ArrayList<>();
    firstRow.add(1L);
    list.add(firstRow);
    
    // Generate Pascal's Triangle row by row
    for (int i = 1; i < numRows; i++) {
        ArrayList<Long> previousRow = list.get(i - 1);
        ArrayList<Long> currentRow = new ArrayList<>();
        
        // The first element is always 1
        currentRow.add(1L);
        
        // Calculate the middle elements
        for (int j = 1; j < i; j++) {
            Long val = previousRow.get(j) + previousRow.get(j - 1);
            currentRow.add(val%1000000007);
        }
        
        // The last element is always 1
        currentRow.add(1L);
        
        // Add the current row to the list
        list.add(currentRow);
    }
    
    // Return the last row
    return list.get(numRows - 1);
    }
}
