# Java Generics - Briefing

## What are generics?
Generics enable types (classes and methods) to operate on objects of various types while providing compile-time type safety and avoiding casts.

## Basic syntax
Generic class example:
```java
class Box<T> {
    private T value;
    public Box(T value) { this.value = value; }
    public T get() { return value; }
}
