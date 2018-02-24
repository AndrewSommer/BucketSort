import java.util.Random;

/**
 * This class contains only the main method. It is the driver
 * class for the BucketSort program
 *
 * @author Andrew Sommer
 * @version 1.0.0 06 February 2018
 */
public class BucketSortDriver {
    public static void main(String[] args) {

        //Give Random Array
        Random random = new Random();
        int size = 10000;
        int bound = 10000;
        int[] unsortedArray = new int[size];

        //Print the unsorted array
        System.out.println("Unsorted Array:");
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(bound);
            System.out.print(unsortedArray[i]);
            if (i != unsortedArray.length - 1) {
                System.out.print(",");
            } else {
                System.out.println();
            }
        }

        //Sort the array using the BucketSort class
        int[] sortedArray = BucketSort.sort(unsortedArray);

        //Print the sorted array
        System.out.println("Sorted Array:");
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
            if (i != sortedArray.length - 1) {
                System.out.print(",");
            } else {
                System.out.println();
            }
        }
    }
}
