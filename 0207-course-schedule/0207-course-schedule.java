// numCourses = 6
// prerequisites = [
//   [2, 1],  // To take 2, finish 1
//   [3, 2],  // To take 3, finish 2
//   [4, 3],  // To take 4, finish 3
//   [5, 4],  // To take 5, finish 4
//   [3, 0]   // To take 3, finish 0
// ]

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
          adj.add(new ArrayList<Integer>());

        int[] inDegree=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();

        for(int[] entireRow:prerequisites)
        {
            int course=entireRow[0];
            int neededCourse=entireRow[1];
            adj.get(neededCourse).add(course);
            inDegree[course]++;
        }

        for(int i=0;i<numCourses;i++)
          if(inDegree[i]==0)
             q.add(i);

        List<Integer> res=new ArrayList<>(); 

        while(!q.isEmpty())
        {
            int completedCourse=q.poll();
            res.add(completedCourse);
            for(int nextCouse:adj.get(completedCourse))
            {
                inDegree[nextCouse]--;
                if(inDegree[nextCouse]==0)
                  q.add(nextCouse);
            }
        }
        
        return numCourses==res.size();
    }
}