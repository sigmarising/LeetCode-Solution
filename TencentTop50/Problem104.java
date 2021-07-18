package TencentTop50;

import java.util.LinkedList;
import java.util.Queue;

public class Problem104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalLevel = 1;

        while (!queue.isEmpty()) {
            int currentLevelNum = queue.size();

            for (int i = 0; i < currentLevelNum; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);

            }

            if (!queue.isEmpty())
                totalLevel++;
        }

        return totalLevel;
    }
}
