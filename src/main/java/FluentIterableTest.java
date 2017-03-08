import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 代码来自“ http://blog.csdn.net/wenniuwuren”
 * Guava提供了可以在Iterator中进行处理的功能更丰富的迭代器， 其实就像是加了一个代理， 增加一些功能
 */
public class FluentIterableTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Person person1 = new Person("lilei", 50);
        Person person2 = new Person("hanmeimei", 40);
        Person person3 = new Person("Jack",30);
        Person person4 = new Person("Tom",20);

        @SuppressWarnings("rawtypes")
        ArrayList personList = Lists.newArrayList(person1, person2);

        ArrayList<Person> personList2 = Lists.newArrayList(person1, person2, person3, person4);

        HashSet<Person> personHashSet = Sets.newHashSet(person3, person4);

        Sets.newHashSet(personList);

        //返回一个按条件过滤后的结果集
        Iterable<Person> personFilterByAge = FluentIterable.from(personList)
                .filter(new Predicate<Person>() {

                    public boolean apply(Person input) {

                        return input.getAge() > 40;
                    }

                });
        Iterator<Person> i = personFilterByAge.iterator();
        while(i.hasNext()) {
            System.out.println("年龄大于40的是：" + i.next().getName());
        }

        System.out.println("-------------分割线-------------");

        // 返回处理过的结果集
        List<String> transformedPersonList = FluentIterable.from(personList)
                .transform(new Function<Person, String>() {
                    public String apply(Person input) {
                        return Joiner.on(':').join(input.getName(), input.getAge());
                    }

                }).toList();
        Iterator transformedPersonListIterator = transformedPersonList.iterator();
        while(transformedPersonListIterator.hasNext()) {
            System.out.println("拼接起来的结果是：" + transformedPersonListIterator.next());
        }

    }


}

class Person {
    private String name;
    private int age;
    private String id;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

