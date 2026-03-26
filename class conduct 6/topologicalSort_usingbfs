class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[V];
        for(int i = 0 ; i < V ; i++ ){
            adj[i] = new ArrayList<>();
        }
        for( int e[] : edges ){
            adj[e[0]].add(e[1]);
        }
        

        
        
        int in[] = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            for(int neigh : adj[i]){
                in[neigh]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < V ; i++){
            if( in[i] == 0 ){
                q.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[V];
        
        while( !q.isEmpty() ){
            int curr = q.poll();
            
            for(int neigh : adj[curr]){
                in[neigh]--;
                if( in[neigh] == 0 ){
                    q.offer(neigh);
                }
            }
            
            ans.add(curr);
        }
        
        return ans;
    }
}
