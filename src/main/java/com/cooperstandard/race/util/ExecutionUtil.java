package com.cooperstandard.race.util;

import com.cooperstandard.race.interfaces.CheckedFunction;

public class ExecutionUtil {

    public static <R extends Object> R trySelfExecution(CheckedFunction function, R defaulReturn) {
        try {
            return (R) function.apply();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return defaulReturn;
    }

}
