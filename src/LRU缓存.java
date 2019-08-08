import java.util.*;

//public class LRU缓存 {
//    private Deque<Integer> deque;
//    private HashMap<Integer, Integer> map;
//    private int MAX_LENGTH;
//    private int size = 0;
//
//    public LRUCache(int capacity) {
//        deque = new LinkedList<>();
//        map = new HashMap<>();
//        MAX_LENGTH = capacity;
//    }
//
//    public int get(int key) {
//        if (map.keySet().contains(key)) {
//            int value = map.get(key);
//            deque.remove(Integer.valueOf(key));
//            deque.addFirst(key);
//            return value;
//        } else {
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//        if (!map.keySet().contains(key) && size == MAX_LENGTH) {
//            map.remove(deque.peekLast());
//            deque.removeLast();
//            size--;
//        }
//        if (!map.keySet().contains(key)) {
//            size++;
//        }
//        map.put(key, value);
//        deque.remove(Integer.valueOf(key));
//        deque.addFirst(key);
//
//    }
//}

class LRU缓存 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRU缓存(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

