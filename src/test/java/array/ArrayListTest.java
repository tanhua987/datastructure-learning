package array;

import domian.Person;
import org.junit.Test;

public class ArrayListTest {

    @Test
    public void get() {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(5));

    }

    @Test
    public void remove(){
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        arrayList.remove(0);
        System.out.println(arrayList);
        arrayList.remove(0);
        System.out.println(arrayList);
        arrayList.remove(0);
        System.out.println(arrayList);
    }


    @Test
    public void set() {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        arrayList.set(5, 100);
        arrayList.add(5, 1000);
        System.out.println(arrayList);
    }

    @Test
    public void indexOf(){
        Person p1 = new Person("张三");
        Person p2 = new Person("李四");
        Person p3 = new Person("王五");
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        System.out.println(persons.indexOf(p2));
        System.out.println(persons.indexOf(new Person()));
    }

    @Test
    public void contains(){
        Person p1 = new Person("张三");
        Person p2 = new Person("李四");
        Person p3 = new Person("王五");
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        System.out.println(persons.contains(p2));
        System.out.println(persons.contains(new Person()));
    }

    @Test
    public void resize(){
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
            if(i%10==0){
                System.out.println(arrayList);
            }
        }
    }
}
