//Inversion of array
/*
Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is
already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5
has three inversions (2, 1), (4, 1), (4, 3).
*/

package ds99.interview.allLevel;

public class Arrays16 {
    static long answer = 0;


    static int brutSolution(int[] arr, int n) {           //this approach can also be use to sort an array using as brute force solution in O(n2) time complexity
        int count = 0;
        //we are finding what should be the ideal position for ith element in sorted array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    static long inversionCount(long[] arr, long n) {

        if (n < 2) return 0;

        long mid = n / 2;
        long[] left = new long[(int) mid];
        long[] right = new long[(int) (n - mid)];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = (int) mid; i < n; i++) {
            right[(int) (i - mid)] = arr[i];
        }
        inversionCount(left, left.length);
        inversionCount(right, right.length);
        answer = merge(arr, left, right, answer);
        return answer;

    }


    static long merge(long[] a, long[] l, long[] r, long ans) {
        int nl = l.length;
        int rl = r.length;
        int i = 0, j = 0, k = 0;

        while (i < nl && j < rl) {

            if (l[i] <= r[j]) {
                a[k++] = l[i++];

            } else {
                a[k++] = r[j++];
                ans += nl - i;                 //this is the only additional line compare to merge sort, rest code is same.
            }
        }

        while (i < nl) {
            a[k++] = l[i++];
        }

        while (j < rl) {
            a[k++] = r[j++];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        //System.out.println(brutSolution(arr, arr.length));
        long[] arr1 = {174, 165, 142 ,212 ,254, 369, 48 ,145, 163, 258, 38, 360 ,224, 242, 30 ,279 ,317 ,36 ,191, 343 ,289 ,107, 41 ,443 ,265 ,149, 447 ,306 ,391, 230, 371, 351 ,7, 102
        };
        System.out.println(inversionCount(arr1, arr1.length));
        ;
    }
}


/*Explanation for logic
Here we have added only one extra line in merge sort algo

*/