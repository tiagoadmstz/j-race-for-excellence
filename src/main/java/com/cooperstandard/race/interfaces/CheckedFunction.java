package com.cooperstandard.race.interfaces;

@FunctionalInterface
public interface CheckedFunction<R, T> {

    R apply() throws Exception;

}
