package bambooSwords.sort;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1) return (double)findKthElement(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2 + 1);
        else return
                (double) (findKthElement(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2) +
                        findKthElement(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2 + 1)) / 2;
    }

    public int findKthElement(int[] A, int[] B, int startA, int startB, int k){

        if (startA >= A.length) return B[startB + k - 1];

        if (startB >= B.length) return A[startA + k - 1];

        if (k == 1) return A[startA] <= B[startB] ? A[startA] : B[startB];

        // always safe to remove k/2 elements
        int midA = startA + k / 2 - 1 >= A.length ? Integer.MAX_VALUE : A[startA + k / 2 - 1];
        int midB = startB + k / 2 - 1 >= B.length ? Integer.MAX_VALUE : B[startB + k / 2 - 1];

//        if (midA == midB) return midA; this line can not be there

        if (midA < midB) return findKthElement(A, B, startA + k / 2, startB, k - k / 2);

        return findKthElement(A, B, startA, startB + k / 2, k - k / 2);
    }
}
