package leetcode.util;

import java.util.Random;

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

    public static int[] createArray(int length){
        if (length < 0){
            throw new IllegalArgumentException("Array length can't less than 0");
        }
        int[] array = new int[length];
        Random random = new Random(47);
        for (int i=0 ; i < length; i++){
            array[i] = random.nextInt();
        }
        return array;
    }
}
