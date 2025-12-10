import java.util.Arrays;
import java.util.Scanner;

public class Mainn {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {}; // Empty array to start
        
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Input Array");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search (Sort first!)");
            System.out.println("4. Bubble Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Selection Sort");
            System.out.println("7. Heap Sort");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            
            // Check if input is an integer to prevent crashing
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); 
                continue;
            }
            int choice = sc.nextInt();

            if (choice == 8) {
                System.out.println("Goodbye!");
                break;
            }

            // Option 1: Input Array
            if (choice == 1) {
                System.out.print("Enter size: ");
                int size = sc.nextInt();
                arr = new int[size];
                System.out.println("Enter " + size + " numbers:");
                for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
                System.out.println("Saved: " + Arrays.toString(arr));
            
            // Validation: Check if array exists for other options
            } else if (arr.length == 0) {
                System.out.println("(!) Please input an array first (Option 1).");
            
            // Option 2: Linear Search
            } else if (choice == 2) { 
                System.out.print("Find what? ");
                int target = sc.nextInt();
                int idx = linearSearch(arr, target);
                System.out.println(idx != -1 ? "Found at index " + idx : "Not found");

            // Option 3: Binary Search
            } else if (choice == 3) { 
                System.out.print("Find what? ");
                int target = sc.nextInt();
                int idx = binarySearch(arr, target);
                System.out.println(idx != -1 ? "Found at index " + idx : "Not found (Did you sort first?)");

            // Options 4-7: Sorting
            } else if (choice >= 4 && choice <= 7) { 
                // Clone array so we don't permanently sort the original if user wants to test others
                int[] tempArr = arr.clone(); 
                
                if (choice == 4) bubbleSort(tempArr);
                else if (choice == 5) quickSort(tempArr, 0, tempArr.length - 1);
                else if (choice == 6) selectionSort(tempArr);
                else if (choice == 7) heapSort(tempArr);
                
                System.out.println("Result: " + Arrays.toString(tempArr));
                arr = tempArr; // Save the sorted version
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    // --- 1. Linear Search ---
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // --- 2. Binary Search ---
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // --- 3. Bubble Sort ---
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // --- 4. Selection Sort ---
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // --- 5. Quick Sort ---
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
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
            
            // Recursion
            quickSort(arr, low, i);
            quickSort(arr, i + 2, high);
        }
    }

    // --- 6. Heap Sort ---
    static void heapSort(int[] arr) {
        int n = arr.length;
        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        // Extract elements
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
