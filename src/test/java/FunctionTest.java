import com.dexi.utils.core.lang.func.Func;
import org.junit.Test;
import scala.Int;

import java.util.function.Function;
import java.util.function.Predicate;

interface Description {
    String brief();
}
interface FourAge {
    String bref(String a, String b, String c);
}
interface  FourAdd {
    Integer apple(Integer i, Integer c, Integer d);
}
interface FourTwo {
    Integer apply(Integer i, Integer b);
}

interface Function1<T, R, K> {
    K apply(T t, R r);
}

//add(10, 10)(10)
//add(10,10,10)
interface FunArg {
    //类型签名
    Integer add(FourAdd f, Integer a, Integer b, Integer c);
}
public class FunctionTest {
    //定义函数作为参数
    public Integer add(FourAdd add, Integer a, Integer b, Integer c) {
        return add.apple(a, b, c);
    };
    //函数作为返回
    public FourAdd add2() {
        return (x, y, z) -> (x + y +z);
    }
    //柯里化
    public Function1<Integer, Integer, Function<Integer, Integer>> add3() {
        return (x, y) -> (z) -> (x + y + z);
    }

    @Test
    public void Lambda() {

        Function<String, String> test = (x) -> x + "ggg";
        System.out.println(test.apply("xx"));

        Description des = ()-> ("hhhhh");
        System.out.println(des.brief());

        Predicate<String> predicate = (x) -> (x.equals("hhh"));
        System.out.println(predicate.test("hhh"));
        //定义4个参数的表达式

        FourAge fourAge = (x, y, z) -> (x + y + z);
        System.out.println(fourAge.bref("I", "love", "you"));

        //类型为函数
        FourAdd fourAdd = (x, y, z) -> (x +y +z);

        //函数作为参数
        add((x,y,z)-> (x+y+z), 1,2,3);
        add((x, y, z)-> (x*y*z), 1,2,3);

        //函数作为返回
        add2().apple(1,2,3);

        //柯里化
        //add3(10).apply(2);
        Integer test1 = add3().apply(10,20).apply(10);
        System.out.println(test1);








        //参数为函数








    }




}
