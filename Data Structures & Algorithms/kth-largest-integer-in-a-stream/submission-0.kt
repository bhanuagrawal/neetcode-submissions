class KthLargest(val k: Int, val nums: IntArray) {

    val heap = PriorityQueue<Int>()

    init{
        for(num in nums){
            add(num)
        }
    }

    fun add(num: Int) = run {
        if(heap.size == k && heap.peek() > num) return heap.peek()
        heap.add(num)
        if(heap.size > k) heap.poll()
        heap.peek()
    }

}
