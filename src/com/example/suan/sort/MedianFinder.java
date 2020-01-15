package com.example.suan.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  双堆在海量数据中 寻找中位数 ，这时候需要进行排序。但是呢，又不需要完全的排序
 *  需要判断 堆的情况
 *  https://github.com/doocs/advanced-java/blob/master/docs/big-data/find-mid-value-in-500-millions.md
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxQueue = new PriorityQueue(Comparator.reverseOrder());
    private PriorityQueue<Integer> minQueue = new PriorityQueue<>(Integer::compareTo);

    public void add(int value) {
        if (maxQueue.isEmpty() || value > maxQueue.peek()) {
            maxQueue.offer(value);
        }
        int maxSize = maxQueue.size();
        int minSize = minQueue.size();
        if (maxSize- minSize > 1) {
            minQueue.offer(maxQueue.poll());
        }else if(minSize - maxSize > 1) {
            maxQueue.offer(minQueue.poll());
        }
    }

    /**
     *  如果两个堆 的元素 size 一致，表示为 偶数，否则 哪个大就是哪个的堆顶元素
     * @return
     */
    public double findMid() {
        int size1 = maxQueue.size();
        int size2 = minQueue.size();

        return size1 == size2
                ? (maxQueue.peek() + minQueue.peek()) * 1.0 / 2
                : (size1 > size2 ? maxQueue.peek() : minQueue.peek());
    }
}
