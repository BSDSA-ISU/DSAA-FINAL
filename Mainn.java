import java.util.Scanner;
import java.util.Arrays;

public class Mainn {

    static Scanner scanner = new Scanner(System.in);
    static int[] currentArray = null;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getValidInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    inputArray();
                    break;
                case 2:
                    performLinearSearch();
                    break;
                case 3:
                    performBinarySearch();
                    break;
                case 4:
                    performBubbleSort();
                    break;
                case 5:
                    performQuickSort();
                    break;
                case 6:
                    performSelectionSort();
                    break;
                case 7:
                    performHeapSort();
                    break;
                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("\n--------------------------------------------\n");
        }
        scanner.close();
    }

    // --- Helper Methods ---

    static void printMenu() {
        System.out.println("=== ALGORITHM MENU ===");
        System.out.println("1. Input New Array");
        System.out.println("2. Linear Search");
        System.out.println("3. Binary Search (Requires sorted array)");
        System.out.println("4. Bubble Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Selection Sort");
        System.out.println("7. Heap Sort");
        System.out.println("8. Exit");
    }

    static int getValidInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume bad input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    static void inputArray() {
        int size = getValidInput("Enter array size: ");
        currentArray = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            currentArray[i] = getValidInput("Element " + (i + 1) + ": ");
        }
        System.out.println("Array saved: " + Arrays.toString(currentArray));
    }

    static boolean isArrayEmpty() {
        if (currentArray == null || currentArray.length == 0) {
            System.out.println("(!) Please input an array first (Option 1).");
            return true;
        }
        return false;
    }

    // --- Wrapper Methods for Menu logic ---

    static void performLinearSearch() {
        if (isArrayEmpty()) return;
        int target = getValidInput("Enter target number to search: ");
        int result = linearSearch(currentArray, target);
        if (result != -1)
            System.out.println("Target found at index: " + result);
        else
            System.out.println("Target not found.");
    }

    static void performBinarySearch() {
        if (isArrayEmpty()) return;
        // Check if sorted? For this demo, we assume user knows, or we sort a copy.
        // To ensure it works, let's warn the user.
        System.out.println("Note: Binary Search produces undefined results if the array is not sorted.");
        int target = getValidInput("Enter target number to search: ");
        int result = binarySearch(currentArray, target);
        if (result != -1)
            System.out.println("Target found at index: " + result);
        else
            System.out.println("Target not found.");
    }

    static void performBubbleSort() {
        if (isArrayEmpty()) return;
        int[] arrCopy = currentArray.clone(); // Clone to keep original intact if desired, or remove .clone() to modify permanently
        System.out.println("Original: " + Arrays.toString(arrCopy));
        bubbleSort(arrCopy);
        System.out.println("Sorted (Bubble): " + Arrays.toString(arrCopy));
        currentArray = arrCopy; // Update global state
    }

    static void performQuickSort() {
        if (isArrayEmpty()) return;
        int[] arrCopy = currentArray.clone();
        System.out.println("Original: " + Arrays.toString(arrCopy));
        quickSort(arrCopy, 0, arrCopy.length - 1);
        System.out.println("Sorted (Quick): " + Arrays.toString(arrCopy));
        currentArray = arrCopy;
    }

    static void performSelectionSort() {
        if (isArrayEmpty()) return;
        int[] arrCopy = currentArray.clone();
        System.out.println("Original: " + Arrays.toString(arrCopy));
        selectionSort(arrCopy);
        System.out.println("Sorted (Selection): " + Arrays.toString(arrCopy));
        currentArray = arrCopy;
    }

    static void performHeapSort() {
        if (isArrayEmpty()) return;
        int[] arrCopy = currentArray.clone();
        System.out.println("Original: " + Arrays.toString(arrCopy));
        heapSort(arrCopy);
        System.out.println("Sorted (Heap): " + Arrays.toString(arrCopy));
        currentArray = arrCopy;
    }

    // ==========================================
    // ======= ALGORITHM IMPLEMENTATIONS ========
    // ==========================================

    // 1. Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 2. Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // 3. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 4. Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // 5. Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // 6. Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
