package com.AndreaPop.Automation.utils;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CaptchaHelper {
    public static int solveCapcha(String capcha){
        Expression expression = new ExpressionBuilder(capcha).build();
        return (int) expression.evaluate();
    }
}
