class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for( int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for( int[] pre : prerequisites ){
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);

            indegree[course]++;


        }
        Queue<Integer> queue = new LinkedList<>();

        for( int i = 0 ; i < numCourses ;i++){
            if(indegree[i] == 0){
                queue.offer(i);
        }
            
        }
        int[] order = new int[numCourses];

        int index = 0 ; 

        while(!queue.isEmpty()){
            int course = queue.poll();
            order[index++]  = course;

            for( int neighbour : graph.get(course)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        if(index == numCourses){
            return order;
        }
        return new int[0];
    }
}