class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>()

        for(num in nums){

            if(heap.size == k && num < heap.peek()){
                continue
            }

            heap.add(num)
            if(heap.size > k){
                heap.poll()
            }
        }

        return heap.peek()
    }
}
