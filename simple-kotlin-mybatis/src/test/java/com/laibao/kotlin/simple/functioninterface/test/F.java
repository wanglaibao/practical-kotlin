package com.laibao.kotlin.simple.functioninterface.test;

/**
 * @author laibao wang
 */
@FunctionalInterface
public interface F<B, C> {
    C apply(B b);
}
