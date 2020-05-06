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
        //1.返回hhhh
        Description des = ()-> ("hhhhh");
        System.out.println(des.brief());
        //2.java内部提供 => true
        Predicate<String> predicate = (x) -> (x.equals("hhh"));
        System.out.println(predicate.test("hhh"));
        //3.定义4个参数的表达式 => 返回I and you

        FourAge fourAge = (x, y, z) -> (x + y + z);
        System.out.println(fourAge.bref("I", "and", "you"));

        //类型为函数
        FourAdd fourAdd = (x, y, z) -> (x +y +z);

        //4.函数类型作为作为参数 => (1) 6 => (2) => 6
        add((x,y,z)-> (x+y+z), 1,2,3);
        add((x, y, z)-> (x*y*z), 1,2,3);

        //5.函数作为返回 => 6
        add2().apple(1,2,3);

        //6.柯里化
        //add3(10).apply(2);
        Integer test1 = add3().apply(10,20).apply(10);
        System.out.println(test1);

        //7.函数组合 => 结合率
        //(f, y)(x) === (f(y(x)))
        //返回_fter _ll _mbul_nces
        Function<String, String>
                f1 = s -> {
            System.out.println(s);
            return s.replace('A', '_');
        },
                f2 = s -> s.substring(3),
                f3 = s -> s.toLowerCase(),
                f4 = f1.compose(f2).andThen(f3);

        f4.apply("GO AFTER ALL AMBULANCES");





    }




}
