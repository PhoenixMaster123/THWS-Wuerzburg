package org.example;

public interface Transform<E, T>
{
    T transform(E from);
}
