package edu.whu;

import annotations.InitMethod;

public class MyClass {
    public void someOtherMethod() {
        System.out.println("This is some other method.");
    }

    @InitMethod
    public void init() {
        System.out.println("MyClass initialized using @InitMethod.");
    }
}
