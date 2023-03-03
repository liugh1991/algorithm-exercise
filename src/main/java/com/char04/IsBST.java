package main.java.com.char04;

public class IsBST {
    //方法一
    public boolean isBST(TreeNode node){
        if (node == null) {
            return true;
        }
        Info ans = process(node);
        return ans.isBST;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(true,0);
        }
        Info left = process(node.left);
        Info right = process(node.right);
        boolean isBST = left.isBST && right.isBST && Math.abs(left.height - right.height) < 2;
        int height = Math.max(left.height, right.height) + 1;
        return new Info(isBST,height);
    }

    private class Info{
        boolean isBST;
        int height;

        public Info(boolean isBST,int height){
            this.isBST = isBST;
            this.height = height;
        }
    }

        //方法二
        public boolean isBalanced(TreeNode root) {
            return height(root) != -1;
        }

        private int height(TreeNode node) {
            if (node == null) return 0;
            int leftHeight, rightHeight;
            if ((leftHeight = height(node.left)) == -1
                    || (rightHeight = height(node.right)) == -1
                    || Math.abs(leftHeight - rightHeight) > 1)
                return -1;
            return Math.max(leftHeight, rightHeight) + 1;
        }

}
