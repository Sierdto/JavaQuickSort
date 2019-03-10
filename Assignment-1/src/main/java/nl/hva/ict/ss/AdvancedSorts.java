package nl.hva.ict.ss;

import java.util.LinkedList;

public class AdvancedSorts {

    /**
     * Implement quicksort using LinkedList only! Usage of anything but LinkedList will result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> LinkedList<E> quickSort(LinkedList<E> unsorted) {

        new QuickSort();
        QuickSort qs = new QuickSort();

        LinkedList<E> sorted;

        //ignoring that empty unsorted in test setup
        if (unsorted.size() >= 1) {
            qs.sort((LinkedList<Player>) unsorted, 0, unsorted.size() - 1);
        }

        //unsorted is now sorted list
        sorted = unsorted;
        return sorted;
    }

    /**
     * Implement quicksort using arrays only! Usage of anything but arrays will result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E[] quickSort(E[] unsorted) {

        //sorted array
        E[] sorted;

        new QuickSort();
        QuickSort qs = new QuickSort();

        //ignoring that empty unsorted in test setup
        if (unsorted.length >= 1) {
            int high = unsorted.length;
            //quicksort the unsorted array
            qs.sort((Player[]) unsorted, 0, high - 1);
        }

        //even if unsorted is null, still copy it to sorted array
        sorted = unsorted;
        return sorted;
    }


}