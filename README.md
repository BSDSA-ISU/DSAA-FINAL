# Java Algorithms: Search & Sort Suite

This project is a comprehensive Java application designed to demonstrate the mechanics of fundamental computer science algorithms. It features a menu-driven interface allowing users to input custom data and visualize how searching and sorting operations are performed.

---

## A. Algorithm Logic (Overview)

Here is a high-level look at the logic behind the algorithms included in this program:

### Searching
1.  **Linear Search**: The "brute force" method. It looks at the first item, then the second, then the third, and so on, until it finds the target or reaches the end.
2.  **Binary Search**: The "divide and conquer" method. It looks at the middle of the array. If the target is lower, it discards the right half. If higher, it discards the left half. **Crucial Note:** This only works on arrays that are already sorted.

### Sorting
3.  **Bubble Sort**: The "sinking" method. It compares two adjacent numbers. If they are in the wrong order, it swaps them. It repeats this pass until no swaps are needed.
4.  **Selection Sort**: The "pick the best" method. It scans the entire unsorted list to find the smallest number and moves it to the front. Then it scans the remaining numbers for the next smallest, and so on.
5.  **Quick Sort**: The "partition" method. It picks a "pivot" number. It moves everything smaller than the pivot to the left and everything larger to the right. It then recursively does the same for the left and right sides.
6.  **Heap Sort**: The "tree structure" method. It treats the array like a binary tree (Max Heap). It repeatedly extracts the largest element (the root of the tree) and moves it to the end of the array, rebuilding the tree each time.

---

## B. Code Breakdown: How the Functions Work

Here is how the specific Java functions in `AlgorithmDemo.java` operate:

### `linearSearch(int[] arr, int target)`
* **Logic:** Uses a standard `for` loop to traverse `arr` from index `0` to `length-1`.
* **Return:** Immediately returns the index `i` if a match is found. Returns `-1` if the loop finishes without a match.

### `binarySearch(int[] arr, int target)`
* **Logic:** Uses a `while` loop with `left` and `right` pointers.
* **Calculation:** Calculates `mid = left + (right - left) / 2` to prevent integer overflow.
* **Movement:** Adjusts pointers (`left = mid + 1` or `right = mid - 1`) to narrow the search window by half in every iteration.

### `bubbleSort(int[] arr)`
* **Logic:** Uses nested loops. The outer loop (`i`) represents the number of passes. The inner loop (`j`) compares `arr[j]` with `arr[j+1]`.
* **Action:** Swaps elements using a temporary variable `temp` if `arr[j] > arr[j+1]`.

### `quickSort(int[] arr, int low, int high)`
* **Logic:** A recursive function. It checks if `low < high`.
* **Helper:** Calls `partition()`, which places the pivot element in its correct sorted position.
* **Recursion:** Recursively calls itself for the sub-arrays on the left and right of the partition index.

### `selectionSort(int[] arr)`
* **Logic:** The outer loop moves the boundary of the sorted subarray.
* **Action:** The inner loop finds the index of the minimum element (`min_idx`). A swap is performed *once* per outer loop iteration to place the minimum found element at the current correct position.

### `heapSort(int[] arr)`
* **Logic:** First, builds a heap using `heapify`.
* **Action:** A loop extracts elements one by one. It moves the current root (index 0) to the end (index `i`), then calls `heapify` on the reduced heap to restore order.

---

## C. Demonstration (Sample Run)

Below is an example of what happens when you run the program to Sort and then Search.

### 1. Input Data
*User selects Option 1 and inputs 5 numbers.*
```text
Enter array size: 5
Enter 5 integers:
Element 1: 64
Element 2: 34
Element 3: 25
Element 4: 12
Element 5: 22
Array saved: [64, 34, 25, 12, 22]
