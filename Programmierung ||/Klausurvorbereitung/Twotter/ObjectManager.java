package Klausurvorberaitung.Twotter;

import java.util.List;

public interface ObjectManager<T> {
    void serialize(List<T> object);
    List<T> deserialize();
}
