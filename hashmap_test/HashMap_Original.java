package hashmap_test;

public class HashMap_Original<K,V> {

    // HashMapのKey,Value,有効フラグ
    private K[] key;
    private V[] value;
    private Boolean[] isEnable;

    private int defaultSize = 30000000;


    public HashMap_Original(){
        createHashMap(defaultSize);
    }

    public HashMap_Original(int size){
        createHashMap(size);
    }

    // put
    public void put(K key, V value){
    }

    // setter


    // remove

    // test
    public void get() {
        System.out.println(this.key);
        System.out.println(this.value);
        System.out.println(this.key.getClass());
        System.out.println(this.value.getClass());
    }

    private void createHashMap(int size){
        @SuppressWarnings("unchecked")
        K[] k = (K[])new Object[size];
        key = k;

        V[] v = (V[])new Object[size];
        value = v;

        isEnable = new Boolean[size];
    }
}

