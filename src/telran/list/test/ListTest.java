package telran.list.test;

import org.junit.jupiter.api.Test;
import telran.list.interfaces.IList;
import telran.list.model.MyArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    @Test
    void test() {
        IList<Integer> list = new MyArrayList<>();
        assertEquals(list.size(), 0);
        assertTrue(list.isEmpty());
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(3); // 2 7 5 3
        assertEquals(list.size(), 4);
        assertFalse(list.isEmpty());
        list.add(7);
        list.add(4, null); // 2 7 5 3 null 7
        assertEquals(list.size(), 6);
        assertEquals(list.get(2), 5);
        assertEquals(list.get(4),null);
        try {
            System.out.println(list.get(6));
            assertFalse(true);
        } catch (Exception e) {
            System.out.println("OK");
        }
        assertEquals(list.indexOf(7), 1);
        assertEquals(list.indexOf(10),-1);
        assertEquals(list.indexOf(null), 4);
        assertTrue(list.contains(5));
        assertFalse(list.contains(1));
        assertTrue(list.contains(null));
        assertEquals(list.lastIndexOf(7), 5);
        list.remove(Integer.valueOf(5)); // 2 7 3 null 7
        assertEquals(list.lastIndexOf(7),4);
        list.remove(4); // 2 7 3 null
        assertEquals(list.lastIndexOf(7),1);
        assertEquals(list.get(2),3);
        list.set(2,99); // 2 7 99 null
        assertEquals(list.get(2),99);
        assertEquals(list.size(),4);
        for (Integer i: list) {
            System.out.println(i);  // 2 7 99 null
        }
        list.clear();
        assertEquals(list.size(),0);
        assertTrue(list.isEmpty());
    }
}
