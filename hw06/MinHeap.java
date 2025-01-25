import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        // Resize the backing array if necessary
        if (size + 1 == backingArray.length) {
            T[] newArray = (T[]) new Comparable[backingArray.length * 2];
            for (int i = 1; i <= size; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }
        backingArray[++size] = data;
        upheap(size);
    }

    /**
     * Performs the upheap operation to maintain
     * the min-heap property after adding a new element.
     * @param index The index of the newly added element.
     */
    private void upheap(int index) {
        while (index > 1) {
            int parentIndex = index / 2;
            if (backingArray[index].compareTo(backingArray[parentIndex]) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Swaps two elements in the backing array at the specified indices.
     * @param index1 The index of the first element.
     * @param index2 The index of the second element.
     */
    private void swap(int index1, int index2) {
        T temp = backingArray[index1];
        backingArray[index1] = backingArray[index2];
        backingArray[index2] = temp;
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty.");
        }
        T min = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size--] = null;
        downheap(1);
        return min;
    }

    /**
     * Performs the downheap operation to maintain
     * the min-heap property after removing the root element.
     * @param index The index of the element to "bubble down."
     */
    private void downheap(int index) {
        while (index <= size / 2) {
            int leftChildIndex = index * 2;
            int rightChildIndex = index * 2 + 1;

            // Find the smaller child
            int smallerChildIndex = leftChildIndex;
            if (rightChildIndex <= size &&
                    backingArray[rightChildIndex].compareTo(backingArray[leftChildIndex]) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            // Swap if the current node is larger than the smaller child
            if (backingArray[index].compareTo(backingArray[smallerChildIndex]) > 0) {
                swap(index, smallerChildIndex);
                index = smallerChildIndex; // Move down
            } else {
                break;
            }
        }
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}