import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 * 代码来自“ http://blog.csdn.net/wenniuwuren”
 *
 * 测试Guava对JDK List的扩展Lists，方便增加list到list中， 方便拆分list
 */
public class ListTest {
    public static void main(String[] args) {
        Person person1 = new Person("lilei", 50);
        Person person2 = new Person("hanmeimei", 40);
        Person person3 = new Person("kangkang", 20);
        Person person4 = new Person("mary", 20);

        List<Person> personList = Lists.newArrayList(person1, person2, person3, person4);
        // 拆分成[person1, person2, person3], [person4]   第二个参数为拆分长度
        List<List<Person>> subList = Lists.partition(personList, 3);

        Iterator<List<Person>> i = subList.iterator();
        while(i.hasNext()) {
            List<Person> listTemp = (List<Person>)i.next();
            Iterator<Person> iTemp = listTemp.iterator();
            while(iTemp.hasNext()) {
                System.out.println(iTemp.next().getName());
            }
        }
    }
}
