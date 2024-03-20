package ru.progwards.java1.lessons.sets;

import java.util.Set;
import java.util.HashSet;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> res = new HashSet<>(set1);
        res.addAll(set2);
        return res;
    }

    public static Set<Integer> intersection(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> res = new HashSet<>(s1);
        res.retainAll(s2);
        return res;
    }

    public static Set<Integer> difference(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> diffSet = new HashSet<>(s1);
        diffSet.removeAll(s2);
        return diffSet;
    }

    public static Set<Integer> symDifference(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> res = union(s1,s2);
        res.removeAll(intersection(s1,s2));
        return res;
    }
}