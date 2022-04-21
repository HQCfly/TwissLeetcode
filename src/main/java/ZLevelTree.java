import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/4/21 2:41 下午
 */
public class ZLevelTree {

    public List<List<Integer>> getZLevel(Tree root) {
        if (root == null) {
            return null;
        }
        boolean isZigg = true;
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Tree> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        while (!deque.isEmpty()) {
            Deque<Integer> tmp = new ArrayDeque<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Tree node = deque.poll();
                if (isZigg){
                    tmp.addLast(node.val);
                }else {
                    tmp.addFirst(node.val);
                }
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
            ans.add(new LinkedList<>(tmp));
            isZigg = !isZigg;
        }
        return ans;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right = new Tree(3);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);
        List<List<Integer>> ans = new ZLevelTree().getZLevel(root);
        System.out.println(JSONObject.toJSONString(ans));
    }

}

class Tree {
    int val;
    Tree left, right;

    public Tree(int val) {
        this.val = val;
    }

    public Tree(int val, Tree left, Tree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}