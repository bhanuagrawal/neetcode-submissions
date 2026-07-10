class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val indegree = IntArray(numCourses){0}
        val course = Array(numCourses){mutableListOf<Int>()}
        

        for(preq in prerequisites){
            course[preq[1]].add(preq[0])
            indegree[preq[0]]++ 
        }

        val queue = ArrayDeque<Int>()

        for(i in 0 until numCourses){
            if(indegree[i] == 0){
                queue.addLast(i)
            }
        }

        val result = mutableListOf<Int>()

        while(queue.isNotEmpty()){
            val c = queue.removeFirst()
            result.add(c)
            val neighbors = course[c]
            for(n in neighbors){
                indegree[n]--
                if(indegree[n] == 0){
                    queue.addLast(n)
                }
            }
        }

        return if(indegree.sum() == 0){
            result.toIntArray()
        }else{
            intArrayOf()
        }

    }
}
