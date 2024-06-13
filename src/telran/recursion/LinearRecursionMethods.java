package telran.recursion;

public class LinearRecursionMethods {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be a negative");
        }
        int res = 1;
        if (n != 0) {
            res = n * factorial(n - 1);
        }
        return res;
    }

    /**
     * @param a - any integer
     * @param b - positive integer
     */
    public static int pow1(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("b cannot be negative");
        }
        int res = 1;
        if (b != 0) {
            res = a * pow1(a, b - 1);
        }
        return res;
    }

    /**
     * @param a - any integer number
     * @param b - positive integer number
     * @return - a ^ b
     * no cycles
     * only arithmetic operations +, -
     * additional function if any with the same limitations
     */
    public static int pow(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("b cannot be negative");
        }
        int res = 1;
        if (b != 0) {
            res = multiply(a, pow(a, b - 1));
        }
        return res;
    }

    private static int multiply(int a, int b) {
        int res;
        if (b == 0) {
            res = 0;
        } else if (b < 0) {
            res = -multiply(a, -b);
        } else {
            res = a + multiply(a, b - 1);
        }
        return res;
    }

    public static void displayArray(int[] array) {
        displayArray(0, array, false);
    }

    public static void displayArrayReversed(int[] array) {
        displayArray(0, array, true);
    }

    private static void displayArray(int index, int[] array, boolean isReversed) {
        if (index < array.length) {
            if (isReversed) {
                displayArray(index + 1, array, isReversed);
                System.out.print(array[index] + " ");
            } else {
                System.out.print(array[index] + " ");
                displayArray(index + 1, array, isReversed);
            }
        }
    }

    public static int sum(int[] array) {
        return sum(0, array);
    }

    private static int sum(int index, int[] array) {
        int res = 0;
        if (index < array.length) {
            res = array[index] + sum(index + 1, array);
        }
        return res;
    }

    public static void reverse(int array[]) {
        reverse(0, array.length - 1, array);
    }

    private static void reverse(int left, int right, int[] array) {
        if (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            reverse(left + 1, right - 1, array);
        }
    }

    /**
     * @param x - any integer number
     * @return x ^ 2
     * no cycles
     * allowed  only  arithmetic operations +, -
     * no additional functions allowed
     * no static fields
     */
    public static int square(int x) {
        int res;
        if (x < 0) {
            res = square(-x);
        } else if (x == 0) {
            res = 0;
        } else {
            res = x + x + square(x - 1) - 1;
        }
        return res;
    }

    /**
     * @param str    - string
     * @param substr - substring
     * @return true if substr is a substring of a string, false otherwise
     * no cycles
     * allowed only three String methods are charAt(int index); substring(int beginIndex); length();
     */
    public static boolean isSubstring(String str, String substr) {
        boolean res;
        if (str.length() < substr.length()) {
            res = false;
        } else {
            res = isSubstringCheck(str, substr, 0);
        }
        return res;
    }

    private static boolean isSubstringCheck(String str, String substr, int index) {
        int substrLength = substr.length();
        boolean res;
        if (index + substrLength > str.length()) {
            res = false;
        } else if (str.substring(index, index + substrLength).equals(substr)) {
            res = true;
        } else {
            res = isSubstringCheck(str, substr, index + 1);
        }
        return res;
    }
}
