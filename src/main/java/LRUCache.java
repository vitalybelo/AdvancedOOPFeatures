import java.util.ArrayList;
import java.util.List;

public class LRUCache<Type> {

    ArrayList<Type> elements;
    private int size;

    public LRUCache (int size) {
        this.size = (size <= 0 ? 10 : size);
        elements = new ArrayList<>();
    }
    public LRUCache () {
        this(100);
    }

    public void addElement (Type element) {
        int cacheFlow = elements.size() - size;
        if (cacheFlow >= 0) {
            elements.subList(0, cacheFlow + 1).clear();
        }
        elements.add(element);
    }

    public Type getElement (int index) {
        int cacheSize = elements.size();
        if (index < cacheSize)
            return elements.get(index);
        return elements.get(cacheSize - 1);
    }

    public List<Type> getAllElement() {

        return elements;
    }
}
