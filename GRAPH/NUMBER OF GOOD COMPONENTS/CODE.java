// https://www.geeksforgeeks.org/problems/number-of-good-components--170647/0


class Solution {
    
    void dfs(int node, List<List<Integer>> adjList, List<Integer> nodes, boolean[] visited){
        
        if(visited[node])
            return;
            
        nodes.add(node);
        visited[node] = true;
        
        for(int v: adjList.get(node)){
            if(!visited[v]){
                dfs(v, adjList, nodes, visited);
            }
        }
    }
    
    public  int findNumberOfGoodComponent(int e, int vertex, int[][] edges) {
        
        boolean[] visited = new boolean[vertex];
        Arrays.fill(visited, false);
        
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<vertex; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u = edge[0]-1;
            int v = edge[1]-1;
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        int fullyConnectedComponents = 0;
        
        for(int i=0; i<vertex; i++){
            if(!visited[i]){
                List<Integer> connectedNodeList = new ArrayList<>();
                dfs(i, adjList, connectedNodeList, visited);
                if(isFullyConnected(adjList, connectedNodeList)){
                    fullyConnectedComponents++;
                }
            }
        }
        
        return fullyConnectedComponents;
        
    }
    
    public boolean isFullyConnected(List<List<Integer>> adjList,
                                    List<Integer> nodes){
        for(int node: nodes){
            if(adjList.get(node).size()!=nodes.size()-1)
                return false;
        }
        
        return true;
        
    }
}