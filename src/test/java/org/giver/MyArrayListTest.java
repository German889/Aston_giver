package org.giver;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
class GiverArrayListTest {

    @org.junit.jupiter.api.Test
    void addElementInEnd() {
        GiverArrayList<Employee> list = new GiverArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Employee giver = new Employee();
            giver.setAge(23);
            giver.setMoney(3000);
            giver.setExperience(1);
            list.add(giver);
            assertEquals(giver, list.get(i));
        }
        assertEquals(1000, list.size());
    }
    @org.junit.jupiter.api.Test
    void addElementToRandomIndex(){
        GiverArrayList<Employee> list = new GiverArrayList<>();
        Random random = new Random();
        for(int i=0; i<1000; i++){
            Employee giver = new Employee();
            giver.setAge(23);
            giver.setMoney(3000);
            giver.setExperience(1);
            list.add(giver);
        }
        for(int i=0; i<1000; i++){
            Employee giver = new Employee();
            giver.setAge(25);
            giver.setMoney(1000);
            giver.setExperience(2);
            int position = random.nextInt(1000);
            list.add(position, giver);
            assertEquals(giver, list.get(position));
        }
    }

    @org.junit.jupiter.api.Test
    void get() {
        GiverArrayList<Employee> list = new GiverArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Employee giver = new Employee();
            giver.setAge(23);
            giver.setMoney(3000);
            giver.setExperience(1);
            list.add(giver);
        }
        for (int i = 0; i < 1000; i++) {
            Employee newGiver = new Employee();
            newGiver.setAge(23);
            newGiver.setMoney(3000);
            newGiver.setExperience(1);
            Employee oneGiver = list.get(i);
            assertTrue(oneGiver.equals(newGiver));
        }
    }

    @org.junit.jupiter.api.Test
    void remove() {
        GiverArrayList<Integer> list = new GiverArrayList<>();
        // Заполнение списка элементами
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        // Удаление элементов с конца списка
        for (int i = 999; i >= 0; i--) {
            Integer element = list.remove(i);
            assertEquals(i, element);
        }
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        GiverArrayList<Employee> list = new GiverArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Employee giver = new Employee();
            giver.setAge(23);
            giver.setMoney(3000);
            giver.setExperience(1);
            list.add(giver);
        }
        list.clear();
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void sort() {
        GiverArrayList<Employee> list = new GiverArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Employee giver = new Employee();
            giver.setAge(23);
            giver.setMoney(3000-i);
            giver.setExperience(1);
            list.add(giver);
        }
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getMoney() - o1.getMoney();
            }
        });
        assertEquals(2001, list.get(999).getMoney());
    }

    @org.junit.jupiter.api.Test
    void set() {
        GiverArrayList<Employee> list = new GiverArrayList<>();
        Employee giver = new Employee();
        giver.setAge(23);
        giver.setMoney(3000);
        giver.setExperience(1);
        list.add(giver);

        Employee anotherGiver = new Employee();
        anotherGiver.setAge(24);
        anotherGiver.setMoney(3000);
        anotherGiver.setExperience(1);
        list.set(0, anotherGiver);
        assertEquals(24, list.get(0).getAge());
    }

    @org.junit.jupiter.api.Test
    void size() {
        GiverArrayList<Employee> list = new GiverArrayList<>();
        Employee giver = new Employee();
        giver.setAge(23);
        giver.setMoney(3000);
        giver.setExperience(1);
        list.add(giver);
        list.add(giver);
        list.add(giver);
        assertEquals(3, list.size());
    }
}

class Employee{
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private int money;
    @Getter
    @Setter
    private int experience;
    public boolean equals(Employee p){
        return this.age == p.age && this.experience == p.experience && this.money == p.money;
    }
}