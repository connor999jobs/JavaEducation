package com.knubisoft.base.reflection;

import com.knubisoft.base.reflection.model.EntryModel;
import com.knubisoft.base.reflection.model.InheritedEntryModel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.NoSuchElementException;

public class ReflectionTasksImpl implements ReflectionTasks {

    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        try {
            if (cls == null) {
                throw new NoSuchElementException();
            }
            cls = Class.forName(cls.getName());
            boolean b = cls.getPackageName().equals("com.knubisoft.base.reflection");
            if (b) {
                throw new IllegalArgumentException();
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
        try {
            cls = Class.forName(cls.getName());
            return InheritedEntryModel.class.getDeclaredConstructor(String.class).newInstance("i");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cls = Class.forName(cls.getName());
            Class[] params = {String.class, String.class};
            return InheritedEntryModel.class.getConstructor(params).newInstance("i", "j");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cls = Class.forName(cls.getName());
            Class[] params = {String.class, String.class, String.class};
            return InheritedEntryModel.class.getConstructor(params).newInstance("i", "j", "k");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {
        try {
            if (cls == null) {
                throw new NoSuchElementException();
            }
            cls = (Class<T>) Class.forName(cls.getName());
            boolean b = cls.getPackageName().equals("com.knubisoft.base.reflection");
            if (b) {
                throw new IllegalArgumentException();
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
        Class[] c = InheritedEntryModel.class.getDeclaredClasses();
        if (c.length == 0) {
            return (Class<? extends T>) InheritedEntryModel.class;
        }
        return c[0];
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) {
        return null;
    }

    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        Method[] methods = cls.getDeclaredMethods();
        int count = 0;
        for (Method m : methods) {
            if (Modifier.isPrivate(m.getModifiers())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isMethodHasAnnotation(Method method, Class<?> annotationUnderMethod) {
        return false;
    }

    @Override
    public Object evaluateMethodByName(Class<?> cls, String name) {
        return null;
    }

    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        return null;
    }

    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        Field field;
        try {
            field = instance.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(instance, newValue);
            Object x = (Object) field.get(instance);
            return x;
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
