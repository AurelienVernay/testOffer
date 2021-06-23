package com.aureltest.testOffer.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

public class MyLogger {

    public void logMethodEntry(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        // method name
        String name = joinPoint.getSignature().toLongString();
        StringBuffer sb = new StringBuffer(name + " called with: [");

        // method arguments values list
        for (int i = 0; i < args.length; i++) {
            Object o = args[i];
            sb.append("'" + o + "'");
            sb.append((i == args.length - 1) ? "" : ", ");
        }
        sb.append("]");

        System.out.println(sb);
    }

    public void logMethodExit(StaticPart staticPart, Object result) {

        // method name
        String name = staticPart.getSignature().toLongString();

        System.out.println(name + " returning: [" + result + "]");
    }

}