package ru.sbt.bodya.hw6.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {

    public static void assign(Object to, Object from) {

        Map<String, Method> gettersFrom = new HashMap<>();

        for (Method methodFrom : from.getClass().getMethods()) {

            if (isGet(methodFrom)) {

                String tmp = methodFrom.getName().substring(3);
                if (!gettersFrom.containsKey(tmp)) {
                    gettersFrom.put(tmp, methodFrom);
                }

            }
        }

        for (Method methodTo : to.getClass().getMethods()) {

            if (isSet(methodTo, gettersFrom)) {

                Method methodFrom = gettersFrom.get(methodTo.getName().substring(3));

                tryToInvoke(methodFrom, methodTo, to, from);

            }
        }
    }

    private static boolean isGet(Method method) {

        if (method.getName().startsWith("get") && method.getParameterCount() == 0 &&
                !void.class.equals(method.getReturnType())) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isSet(Method method, Map gettersFrom) {

        String key = method.getName().substring(3);
        if (method.getName().startsWith("set") && method.getParameterCount() == 1 &&
                gettersFrom.containsKey(key)) {
            return true;
        } else return false;

    }

    private static void tryToInvoke(Method methodFrom, Method methodTo, Object to, Object from) {

        Class returnTypeFrom = methodFrom.getReturnType();
        while (returnTypeFrom != null) {

            if (returnTypeFrom == methodTo.getParameterTypes()[0]) {
                try {
                    methodTo.invoke(to, methodFrom.invoke(from));
                    break;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                returnTypeFrom = returnTypeFrom.getSuperclass();
            }
        }

    }
}