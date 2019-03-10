import java.util.Iterator;
import java.util.LinkedList;

class QuickSort {

    /**
     * This function takes last element as pivot,
     * places the pivot element at its correct
     * position in sorted array, and places all
     * smaller (smaller than pivot) to left of
     * pivot and all greater elements to right
     * of pivot
     *
     * @param arr
     * @param low
     * @param high
     * @return index from where to sort from
     */
    public int partition(Player[] arr, int low, int high) {
        Player playerPivot = arr[high];

        // index of smaller element
        int i = (low - 1);

        for (int j = low; j < high; j++) {

            if (arr[j] != null) {
                if (arr[j].compareTo(playerPivot) >= 1) {
                    i++;

                    // swap arr[i] and arr[j]
                    Player temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Player temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /**
     * @param arr  Contains unsorted array
     * @param low
     * @param high
     */
    void sort(Player arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
	
    /* ----------------------------------------------------------------------------------------------------------
       List implementation
     */

    /**
     * Sort linkedlist, first compare each value and puts these in seperate lists
     * Afterwards its calls the _sort function that will sort them in order
     *
     * @param list
     * @param low
     */
    void sort(LinkedList<Player> list, int low, int high) {
        LinkedList<Player> bigList = new LinkedList<>();
        LinkedList<Player> smallList = new LinkedList<>();

        Player playerPivot = list.get(low);

        Iterator it = list.iterator();
        while (it.hasNext()) {
            //split in 2 seperate lists
            if (list.getFirst().compareTo(playerPivot) >= 1) {
                bigList.addLast(list.getFirst());
            } else {
                smallList.addLast(list.getFirst());
            }
            list.removeFirst();
        }

        _sort(smallList, low, smallList.size() - 1);
        _sort(bigList, low, bigList.size() - 1);

        list.addAll(bigList);
        list.addAll(smallList);
    }

    /**
     * @param list
     * @param low
     * @param high
     * @return
     */
    private int partition(LinkedList<Player> list, int low, int high) {
        Player playerPivot = list.get(high);

        // index of smaller element
        int i = (low - 1);
        int j = low;

        Iterator it = list.iterator();
        while (it.hasNext() && j < high) {
            if (list.get(j) != null) {
                if (list.get(j).compareTo(playerPivot) >= 1) {
                    i++;

                    Player temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
            j++;
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Player temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }


    /**
     *  Recursive sort method that sorts the 2 lists
     * @param arr  Contains unsorted linkedlist
     * @param low
     * @param high
     */
    void _sort(LinkedList<Player> arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            _sort(arr, low, pi - 1);
            _sort(arr, pi + 1, high);
        }
    }
}