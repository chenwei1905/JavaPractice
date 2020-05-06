import com.dexi.utils.core.StrUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CollectionsTest {





    @Test
    /**
     *Collection
     */
    @SuppressWarnings("unchecked")
    public void collection() {

        Collection c = new ArrayList() ;
        c.add(new Orange());
        c.add(new Apple("chen"));
        //Iterator e = c.iterator();
        Collection c1 = new ArrayList();
        c1.add(new Apple("wei"));
        c1.add(new Orange());

        c1.addAll(c);

        System.out.println(c1);
        //java8引进了一个可分离迭代器
        Spliterator s = c1.spliterator();
        s.forEachRemaining(item-> System.out.println(item));

//        List<String> list = Arrays.asList("Apple", "Banana", "Orange");
//
//        Spliterator<String> s1 = list.spliterator();
//        Spliterator<String> s2 = s.trySplit();
//
//        s1.forEachRemaining(item-> System.out.println(item));

    }

    @Test
    public void iterator() {
        Collection c = new ArrayList();
        c.add(new String("test"));
        c.add(1);
        Iterator i = c.iterator();
//        while(i.hasNext()) {
//
//            System.out.println(i.next().toString());
//        }
        i.forEachRemaining(System.out::println);

    }


    @Test
    public void set() {
        HashSet hs = new HashSet();
        LinkedHashSet ls = new LinkedHashSet();
        TreeSet ts = new TreeSet();
        ConcurrentSkipListSet cs = new ConcurrentSkipListSet();
        hs.add("1");
        hs.add("2");
        hs.stream().forEach(item -> {
            System.out.println(item.toString());
        });

    }

    @Test
    public void list() {
        ArrayList al = new ArrayList();
        LinkedList ll = new LinkedList();
        al.add(1);
        al.add(4);
        al.add(2);
        Vector v = new Vector();
        CopyOnWriteArrayList cl = new CopyOnWriteArrayList();

        Collections.sort(al);
        al.forEach(item-> System.out.println(item));

    }


    @Test
    public void comparable() {
        List<String> list = new ArrayList<>();
        list.add(new String("h"));
        list.add(new String("x"));
        //list.stream().filter(item -> item.equals("h")).collect(Collector.);
        list.stream().map(item -> item = item + "hh").forEach(System.out::println);

        System.out.println("*********流的测试*************8");
        System.out.println(list);
        //comparable和Comparator

    }

    @Test
    public void map() {
        String str ="中文饿我去恶趣味去问";
        System.out.println(StrUtils.sub(str, 0, 3));

    }


    @Test
    public void queue() {

    }

    @Test
    public void deque() {

    }

}
