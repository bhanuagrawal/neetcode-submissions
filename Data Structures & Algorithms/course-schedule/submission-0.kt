class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        
        val indegree = IntArray(numCourses){0}
        val course = Array(numCourses){mutableListOf<Int>()}
        

        for(preq in prerequisites){
            course[preq[0]].add(preq[1])
            indegree[preq[1]]++ 
        }

        val queue = ArrayDeque<Int>()

        for(i in 0 until numCourses){
            if(indegree[i] == 0){
                queue.addLast(i)
            }
        }

        while(queue.isNotEmpty()){
            val c = queue.removeFirst()
            val neighbors = course[c]
            for(n in neighbors){
                indegree[n]--
                if(indegree[n] == 0){
                    queue.addLast(n)
                }
            }
        }

        return indegree.sum() == 0

    }
}
