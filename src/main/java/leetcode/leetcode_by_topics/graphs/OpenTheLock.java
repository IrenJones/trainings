package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    public static void main(String[] args) {
        OpenTheLock s = new OpenTheLock();
        s.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
    }

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(String deadend: deadends){
            set.add(deadend);
        }

        int depth = 0;
        Queue<String> q = new LinkedList<>();
        // start
        q.add("0000");

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(!set.contains(cur)){
                    set.add(cur);
                    if(cur.equals(target)){
                        return depth;
                    }
                    q.addAll(getNodes(cur));
                }
            }
            depth++;
        }

        return -1;
    }

    public List<String> getNodes(String s){
        List<String> res = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            res.add(s.substring(0, i) + (s.charAt(i) == '0' ? 9 :  s.charAt(i) - '0' - 1) + s.substring(i+1));
            res.add(s.substring(0, i) + (s.charAt(i) == '9' ? 0 :  s.charAt(i) - '0' + 1) + s.substring(i+1));
        }

        return res;
    }
}
