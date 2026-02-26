
//problem desc: https://www.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/
class Solution {

    int count;

    void dfs(Node root, int l, int h){

        if(root==null)
            return;

        if(root.data<l){
            dfs(root.right, l, h);
        }else if(root.data>h){
            dfs(root.left, l, h);
        }else{
            count++;
            dfs(root.left, l, h);
            dfs(root.right, l, h);
        }
    }

    // int getCount(Node root, int l, int h) {
    //     // Your code here
    //     count = 0;
    //     dfs(root, l, h);
    // return count;

    // }

    int getCount(Node root, int l, int h) {
        if (root == null) return 0;

        if (root.data < l) {
            return getCount(root.right, l, h);
        }

        if (root.data > h) {
            return getCount(root.left, l, h);
        }

        return 1 + getCount(root.left, l, h)
                + getCount(root.right, l, h);
    }
}