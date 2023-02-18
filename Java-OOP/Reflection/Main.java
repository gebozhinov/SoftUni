package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields).sorted(Comparator.comparing(Field::getName)).filter(f -> {
            int field = f.getModifiers();
            return !Modifier.isPrivate(field);
        }).forEach(f -> System.out.printf("%s must be private!%n", f.getName()));


        Method[] methods = clazz.getDeclaredMethods();

        List<Method> getters = Arrays.stream(methods).filter(m -> m.getName().startsWith("get"))
                .collect(Collectors.toList());
        List<Method> setters = Arrays.stream(methods).filter(m -> m.getName().startsWith("set"))
                .collect(Collectors.toList());


        getters.stream().sorted(Comparator.comparing(Method::getName))
                .filter(m -> {
                    int modifier = m.getModifiers();
                    return !Modifier.isPublic(modifier);
                })
                .forEach(e -> System.out.printf("%s have to be public!%n", e.getName()));


        setters.stream().sorted(Comparator.comparing(Method::getName))
                .filter(e -> {
                    int modifier = e.getModifiers();
                    return !Modifier.isPrivate(modifier);
                }).forEach(m -> System.out.printf("%s have to be private!%n", m.getName()));


    }
}
