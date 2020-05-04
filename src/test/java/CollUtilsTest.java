import com.dexi.utils.core.collection.CollUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollUtilsTest {

    @Test
    public void collJoin() {
        List<String> l = new ArrayList<>();
        l.add("axxxx");
        l.add("b");
        Iterator i = l.iterator();
        CharSequence c = "cweqewqewqe";

        String l1 = CollUtils.join(l, c); //方法有啥用
        System.out.println(l1);
    }
}
