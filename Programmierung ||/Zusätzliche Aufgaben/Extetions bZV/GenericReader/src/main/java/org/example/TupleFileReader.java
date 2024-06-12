package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TupleFileReader<V>
{
    public class FileContentImpl implements FileContent<Map<String, List<V>>>{
        List<Tuple<String, List<V>>> content;

        public FileContentImpl(List<Tuple<String, List<V>>> content) {
            this.content = content;
        }

        public Map<String, List<V>> get()
        {
            Map<String, List<V>> result = new HashMap<>();
            for (Tuple<String,List<V>> tuple :content)
            {
                result.put(tuple.item1, tuple.item2);
            }
            return result;
        }
    }
}
