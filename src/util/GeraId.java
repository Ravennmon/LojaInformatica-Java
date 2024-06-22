package util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GeraId {
    private static final ConcurrentHashMap<Class<?>, AtomicInteger> contador = new ConcurrentHashMap<>();

    private GeraId() {}

    public static int getProximoId(Class<?> classe) {
        contador.putIfAbsent(classe, new AtomicInteger(0));
        return contador.get(classe).incrementAndGet();
    }
}
