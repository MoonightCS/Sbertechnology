package ru.sbt.bodya.hw6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {

    public static void assign(Object to, Object from) {

        Map<String, Method> gettersFrom = new HashMap<>();
        String tmp;


        for (Method method : from.getClass().getMethods()) {

            if (isGet(method)) {

                tmp = method.getName().substring(3);
                if (!gettersFrom.containsKey(tmp)) {
                    gettersFrom.put(tmp, method);
                }

            }
        }

        for (Method method : to.getClass().getMethods()) {

            tmp = method.getName().substring(3);

            if (isSet(method, gettersFrom, tmp)) {

                Method methodFrom = gettersFrom.get(tmp);

                Class returnTypeFrom = methodFrom.getReturnType();

                tryToInvoke(methodFrom, method, returnTypeFrom, to, from);

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

    private static boolean isSet(Method method, Map gettersFrom, String key) {

        if (method.getName().startsWith("set") && method.getParameterCount() == 1 &&
                gettersFrom.containsKey(key)) {
            return true;
        } else return false;

    }

    private static void tryToInvoke(Method methodFrom, Method methodTo, Class returnTypeFrom,
                                    Object to, Object from) {

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