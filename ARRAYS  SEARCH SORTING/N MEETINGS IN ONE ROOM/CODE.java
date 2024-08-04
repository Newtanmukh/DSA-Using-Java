class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    

///NOTE  :  Logic is that, we need to sort it on based on endTime. This is because, we will PREFER those meetings which ends fast
// now the point is that we could have sorted based on startTime as well, but if startime is early it does not necessaruly mean that endtime is also early.
// whereas, if we sort on basis of endTime, it is confirm that startTime will be early. so thats why.
    
    class Pair{
        int start;
        int end;
        
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    
    public int maxMeetings(int n, int start[], int end[]) {
         ArrayList<Pair> pairs = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            pairs.add(new Pair(start[i], end[i]));
        }
        
        Collections.sort(pairs, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.end - p2.end;
            }
        });
        
        int meeting = 1;
        int endTime = pairs.get(0).end;
        
        for(int i=1; i<pairs.size(); i++){
            Pair pair = pairs.get(i);
            
            if(pair.start>endTime){
                endTime = pair.end;
                meeting++;
            }
        }
        
        return meeting;
        
        
    }
}