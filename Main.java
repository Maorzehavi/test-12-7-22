import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //exe1
        Random random = new Random();
        int[] num1 = new int[15];
        int[] num2 = new int[15];
        int maxNum1 = 0;
        int currentMaxNum1;
        int currentMaxNum2;
        int maxNum2 = 0;

        for (int i = 0; i < num1.length; i++) {
            num1[i] = random.nextInt(10);
            num2[i] = random.nextInt(10);
        }
        // print the array
        System.out.println("Array 1: " + Arrays.toString(num1));
        System.out.println("Array 2: " + Arrays.toString(num2));
        // exe 2
        for (int i = 2; i < num1.length; i++) {
            currentMaxNum1 = num1[i] + (num1[i - 1] * 10) + (num1[i - 2] * 100);
            currentMaxNum2 = num2[i] + (num2[i - 1] * 10) + (num2[i - 2] * 100);
            if (currentMaxNum1 > maxNum1) {
                maxNum1 = currentMaxNum1;
            }
            if (currentMaxNum2 > maxNum2) {
                maxNum2 = currentMaxNum2;
            }
        }
        //exe 3
        System.out.println("Max number in array 1: " + maxNum1);
        System.out.println("Max number in array 2: " + maxNum2);

        //exe 4
        int[] distinct = removeDuplicatesFromTwoArrays(num1, num2);
        // exe 5
        System.out.println(Arrays.toString(distinct));
        // exe 6
        int rev = 0;
        for (int i = distinct.length - 1; i > 0; i--) {
            if (distinct[i] != -1) {
                rev = rev* 10+distinct[i];
            }
        }
        rev *= 10;
        rev += distinct[0];
        System.out.println(rev);

    }
    public static int[] removeDuplicates(int[] nums1) {
        int[] res = new int[10];
        Arrays.fill(res, -1);
        int idx = 0;
        boolean isExist;
        for (int k : nums1) {
            isExist = false;
            for (int re : res) {
                if (re == k) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                res[idx] = k;
                idx++;
            }
        }
        return res;
    }
    // remove duplicates from array1 and array2 and return the result
    public static int[] removeDuplicatesFromTwoArrays(int[] arr1, int[] arr2) {
        int[] res = new int[10];
        Arrays.fill(res, -1);
        int idx = 0;
        boolean isExist;
        for (int i : arr1) {
            isExist = false;
            for (int j : arr2) {
                if (i == j) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                res[idx++] = i;
            }
        }
        for (int i : arr2) {
            isExist = false;
            for (int j : arr1) {
                if (i == j) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                if (idx < 10) res[idx++] = i;
            }
        }
        return removeDuplicates(res);
    }
}