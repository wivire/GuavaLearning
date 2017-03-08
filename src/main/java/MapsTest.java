import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *

 */
public class MapsTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Person p1 = new Person("zhang_san", 60, "001");
        Person p2 = new Person("li_si", 70, "002");

        List<Person> personList = Lists.newArrayList();
        personList.add(p1);
        personList.add(p2);

        // 将主键当作Map的Key
        Map<String, Person> personMap = Maps.uniqueIndex(personList.iterator(), new Function<Person, String>() {
            public String apply(Person input) {
                return input.getId();
            }

        });
        System.out.println("将主键当作Map的Key:" + personMap);


        // 可以说是Maps.uniqueIndex相反的作用
        Set<Person> personSet = Sets.newHashSet(p1, p2);
        @SuppressWarnings("unused")
        Map<Person, String> personAsMap = Maps.asMap(personSet, new Function() {
            public Object apply(Object input) {
                return ((Person) input).getId();
            }
        });
        System.out.println(personAsMap);


        // 转换Map中的value值
        Map<String, String> transformValuesMap = Maps.transformValues(personMap, new Function<Person, String>() {
            public String apply(Person input) {
                return input.getName();
            }
        });
        System.out.println("转换Map中的value值" + transformValuesMap);
    }
}