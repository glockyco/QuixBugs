package quixbugs.correct;

import java.util.*;

import quixbugs.shared.Pair;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derricklin
 */
public class HANOI {
    // default start=1, end=3
    public static List<Pair<Integer,Integer>> hanoi(int height, int start, int end) {
        ArrayList<Pair<Integer,Integer>> steps = new ArrayList<Pair<Integer,Integer>>();

        if (height > 0) {
            PriorityQueue<Integer> crap_set = new PriorityQueue<Integer>();
            crap_set.add(1);
            crap_set.add(2);
            crap_set.add(3);
            crap_set.remove(start);
            crap_set.remove(end);
            int helper = crap_set.poll();
            steps.addAll(hanoi(height-1, start, helper));
            steps.add(new Pair<Integer,Integer>(start, end));
            steps.addAll(hanoi(height-1, helper, end));
        }

        return steps;
    }
}
