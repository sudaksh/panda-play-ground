package bambooSwords.BfsDfsTree;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            return generateBST(nums, 0, nums.length - 1);
        }

        public TreeNode generateBST(int[] nums, int l, int r){
            TreeNode t = null;
            int mid = (l + r) / 2;
            if (l < r){
                t = new TreeNode(nums[mid]);
                t.left = generateBST(nums, 0, mid - 1);
                t.right = generateBST(nums, mid + 1, nums.length - 1);
            }
            return t;
        }
    }
}
