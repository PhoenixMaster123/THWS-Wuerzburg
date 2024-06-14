package org.example;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R, E extends Exception>
{
    R apply(T t) throws E;
    static <T, R, E extends Exception> Function<T, R> unchecked(ThrowingFunction<T, R, E> function)
    {
        return t -> {
            try
            {
                return function.apply(t);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        };
    }
}
