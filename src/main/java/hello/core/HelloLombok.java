package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLomok = new HelloLombok();
        helloLomok.setName("asdfas");

        String name = helloLomok.name;
        System.out.println("name = " + name);
    }
}


