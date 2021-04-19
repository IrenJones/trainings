package leetcode.leetcode_by_topics.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class FlattenNestedListIterator {
}


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
}
// not the right way how to do it, iterator doesn't store the data, so we need to fix it
//class NestedIterator implements Iterator<Integer> {
//
//    private Queue<Integer> q;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        q = new LinkedList<>();
//        init(nestedList);
//    }
//
//    private void init(List<NestedInteger> lists) {
//        for (NestedInteger list : lists) {
//            if (list.isInteger()) {
//                q.add(list.getInteger());
//            }
//            else {
//                init(list.getList());
//            }
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return q.poll();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return !q.isEmpty();
//    }
//}

class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();

        for(int i = nestedList.size() - 1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            for(int i = list.size() - 1; i>=0; i--) {
                stack.push(list.get(i));
            }
        }

        return stack.size() > 0;
    }
}
