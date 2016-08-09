package ru.sbt.bodya.hw6;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class BeanUtils {

    public static void assign(Object to, Object from) {

        Map<String, Method> gettersFrom = new HashMap<>();
        Class returnTypeFrom;
        Method methodFrom;
        String tmp;


        for (Method method : from.getClass().getMethods()) {

            if (method.getName().startsWith("get") && method.getParameterCount() == 0 &&
                    !void.class.equals(method.getReturnType())) {

                tmp = method.getName().substring(3);
                if (!gettersFrom.containsKey(tmp)) {
                    gettersFrom.put(tmp, method);
                }

            }
        }

        for (Method method : to.getClass().getMethods()) {

            tmp = method.getName().substring(3);

            if (method.getName().startsWith("set") && method.getParameterCount() == 1 &&
                    gettersFrom.containsKey(tmp)) {

                methodFrom = gettersFrom.get(tmp);

                returnTypeFrom = gettersFrom.get(tmp).getReturnType();

                while (returnTypeFrom != null) {

                    try {

                        to.getClass().getMethod(method.getName(), returnTypeFrom);
                        method.invoke(to, methodFrom.invoke(from));
                        break;

                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.out.println(e.getMessage());
                    } catch (NoSuchMethodException e) {
                        returnTypeFrom = returnTypeFrom.getSuperclass();
                    }

                }

            }

        }

    }

}