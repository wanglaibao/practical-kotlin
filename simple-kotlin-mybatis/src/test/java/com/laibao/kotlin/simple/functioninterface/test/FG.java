package com.laibao.kotlin.simple.functioninterface.test;

/**
 * @author laibao wang
 */
@FunctionalInterface
public interface FG<A,B,C> {
    C apply(A a);
}
