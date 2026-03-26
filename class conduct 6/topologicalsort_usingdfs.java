class Solution {
    
    void dfs(int node , Deque<Integer> st , boolean[] visited , ArrayList<Integer>[] adj ){
        visited[node] = true;
        for( int neigh : adj[node] ){
            if( !visited[neigh] ){
                dfs( neigh , st , visited , adj );
            }
        }
        
        st.push(node);
    }
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[V];
        for(int i = 0 ; i < V ; i++ ){
            adj[i] = new ArrayList<>();
        }
        for( int e[] : edges ){
            adj[e[0]].add(e[1]);
        }
        

        boolean[] visited = new boolean[V];
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i = 0 ; i < V ; i++){
            if( !visited[i] ){
                dfs(i , st , visited , adj );
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        while( !st.isEmpty() )ans.add(st.pop());
        
        return ans;
    }
}
