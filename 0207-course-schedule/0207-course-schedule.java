class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for ( int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        for( int[] p : prerequisites){

            int course = p[0];
            int prereq = p[1];

            graph.get(prereq).add(course);
        }

        int state[] =  new int[numCourses];

        for( int i = 0 ; i < numCourses ; i++){
            if(dfs(i,graph,state)){
                return false;
            }
        }
            return true;

        
    }
    private boolean dfs( int node , List<List<Integer>> graph , int[] state){

        if (state[node] == 1 ) return true;

        if (state[node] == 2) return false;

        state[node] = 1;

        for(int next : graph.get(node)){
            if(dfs(next,graph,state)){
                return true;
            }
        }
        state[node] = 2;

        return false;
    }
}