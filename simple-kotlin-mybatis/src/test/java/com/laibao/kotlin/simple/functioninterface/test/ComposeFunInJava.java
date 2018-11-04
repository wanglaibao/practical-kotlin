package com.laibao.kotlin.simple.functioninterface.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laibao wang
 */
public class ComposeFunInJava<A,B,C> {
    public static void main(String[] args) {
        F<Integer, Boolean> f = (x) -> x % 2 != 0;
        G<String, Integer> g = (s) -> s.length();
        FG<String,Integer,Boolean> fg = (x) -> f.apply(g.apply(x));

        List<String> strings = new ArrayList();
        strings.add("a");
        strings.add("ab");
        strings.add("abc");
        List<String> result = new ArrayList();

//        for (String s : strings) {
//            if (fg.apply(s)) {
//                result.add(s);
//            }
//        }
//        System.out.println(result);

        strings.stream()
                .filter(str -> fg.apply(str))
                .forEach(System.out::println);
    }
}
