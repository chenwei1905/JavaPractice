package dataSet;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import scala.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Apple {
    private String name;
    private String color;
    public Apple(String name, String color) {
        this.name = name;
        this.color = color;
    };

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apple)) return false;
        Apple apple = (Apple) o;
        return getName().equals(apple.getName()) &&
                getColor().equals(apple.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor());
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

public class CollectionTest {
    static class Person {
        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        private Integer age;
        Person() {}
        Person(String name, Integer age) {
            this.name = name;
            this.age =  age;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    public static void main(String[] args) throws Exception {

        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        /**
         * 基于Collection
         */
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a", 1));
        personList.add(new Person("b", 2));
        //普通Stream的写法
        personList.stream()
                .map(item -> {item.setAge(item.getAge() + 1); return item;}).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("*******下面为flink的测试***************");
        // new MapFunction 待确认
//        env.fromCollection(personList).map(new MapFunction<Person, Person>() {
//            @Override
//            public Person map(Person person) throws Exception {
//                Person p = new Person();
//                p.setAge(p.getAge() + 1);
//                p.setName(p.getName());
//                return p;
//            }
//        }).print();

        env.fromCollection(personList).map(item -> {item.setAge(item.getAge() + 1); return item;}).print();


        List<Apple> list1 = new ArrayList<>();
        list1.add(new Apple("chen","yellow"));
        list1.add(new Apple("wei", "yellow"));

        List<Apple> list2 = new ArrayList<>();
        list2.add(new Apple("chen", "yellow"));


        boolean x = list1.removeAll(list2);
        System.out.println(list2);
        System.out.println(x);
    }

}
