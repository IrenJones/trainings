package leetcode.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] initOrder = new int[n];

        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(deck[n - 1]);
        for(int i = n - 2; i >= 0; i--){
            if(dq.size() == 1){
                dq.addFirst(deck[i]);
            } else {
                int v = dq.removeLast();
                dq.addFirst(v);
                dq.addFirst(deck[i]);
            }
        }

        for (int i = 0; i < n; i++){
            initOrder[i] = dq.removeFirst();
        }

        return initOrder;
    }
}
