package telran.list.test;

import org.junit.jupiter.api.Test;
import telran.list.interfaces.IList;
import telran.list.model.MyArrayList;

public class ListTest {

    @Test
    void test() {
        IList<Integer> list = new MyArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(7);
        list.add(4, null);
        System.out.println(list.size());
        System.out.println("=== get ===");
        System.out.println(list.get(2));
        System.out.println(list.get(4));
        try {
            System.out.println(list.get(6));
        } catch (Exception e) {
            System.out.println("o-o-ops");
        }
        System.out.println("=== indexOf ===");
        System.out.println(list.indexOf(7));
        System.out.println(list.indexOf(10));
        System.out.println(list.indexOf(null));
        System.out.println(list.contains(5));
        System.out.println(list.contains(1));
        System.out.println(list.contains(null));
        System.out.println("=== lstIndexOf ===");
        System.out.println(list.lastIndexOf(7));
    }
}
