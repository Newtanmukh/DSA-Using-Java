// Problem Link: https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1


class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {

        if(n==0) {
            return 0;//number of moves needed to move 0 disks from 'from' to 'to'.
        }

        int noOfTrips = 0;

        //number of trips to shift top (n-1) disks from 'from' to 'aux'.
        noOfTrips += towerOfHanoi(n-1, from, aux, to);

        //number of trips to shift the big remaing nth disk from 'from' to 'aux'
        noOfTrips++;

        //number of trips to shift the 'n-1' back from 'aux' to 'to'.
        noOfTrips += towerOfHanoi(n-1, aux, to, from);

        return noOfTrips;
    }
}
