package leetcode.util;

/**
 * @author wangchengwei
 * @date 2019/7/2.
 */
public class ArrayUtil {

    public static <T> void printArray(T[] array) {
        if (array == null) {
            throw new NullPointerException("Can't print null array.");
        }
        if (array.length == 0) {
            return;
        }
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        if (array == null) {
            throw new NullPointerException("Can't print null array.");
        }
        if (array.length == 0) {
            return;
        }
        for (int t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
