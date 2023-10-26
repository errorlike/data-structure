import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[] { 5, 8, 3, 1, 0, 4 };
        System.out.println(Arrays.toString(quickSort(nums)));
    }

    public static int[] quickSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        } else {
            int pivot = nums[0];
            int[] less = Arrays.stream(nums).skip(1).filter(item -> item <= pivot).toArray();
            int[] greater = Arrays.stream(nums).skip(1).filter(item -> item > pivot).toArray();
            return IntStream
                    .concat(IntStream.concat(Arrays.stream(quickSort(less)), IntStream.of(pivot)),
                            Arrays.stream(quickSort(greater)))
                    .toArray();
        }

    }
}