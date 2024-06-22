package util.factories;

import java.util.ArrayList;
import java.util.List;

public class CollectionFactory {
    public static <T> List<T> createArrayList() {
        return new ArrayList<>();
    }

    public static <T> List<T> createArrayList(int initialCapacity) {
        return new ArrayList<>(initialCapacity);
    }
}
