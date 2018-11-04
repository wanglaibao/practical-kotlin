package com.laibao.kotlin.simple.functioninterface.test;

/**
 * @author laibao wang
 */
@FunctionalInterface
public interface G<A, B> {
    B apply(A a);
}
