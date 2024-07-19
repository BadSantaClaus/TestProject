package org.example.nested_classes;

import org.example.abstract_class.CustomAbstractClass;
import org.example.abstract_class.CustomInterface;

public class NestedClass extends CustomAbstractClass {


    private int age;

    @Override
    public void execute() {
        System.out.println("hi");
    }

    //Анонимные классы - используются для переопределения методов классов или интерфейсов на месте
    //Широко применяются в лямбда выражениях
    public void anonymous() {
        CustomInterface customInterface = new CustomInterface() {
            @Override
            public void execute() {
                System.out.println("Anonymous ");
            }
        };
    }

    //Вложенные статические классы не видят переменных и методов внешнего класса и существуют отдельно от него
    //Могут применять для улучшения инкапсуляции, группировки утилитарных методов, которые имеют отношение только к внешнему классу.
    //Вложенные статические классы часто используются для реализации шаблона Builder
    public static class StaticInnerClass {

        public void getAllYouHave() {
            System.out.println("I have no rights");
        }
    }

    //Вложенные классы в отличии от статических видят все переменные и методы родителя и могут являются частью экземпляра класса
    public class InnerClass {

        public void getAllYouHave() {
            System.out.println(age);
            System.out.println(name);
        }

        //Локальные классы - это классы, объявленные внутри метода, конструктора или блока и имеют локальную область видимости
        //Локальные классы могут иметь доступ к членам внешнего класса и к локальным переменным метода, если они объявлены
        // как final или "эффективно финальные" (effectively final).
        public void local() {
            class LocalInnerClass {
                void print() {
                    System.out.println(age);
                }
            }
        }
    }

}
