package hashmap_test;

public class HashMap_Original<K,V> {

    // HashMapのKey,Value,有効フラグ
    private int DEFAULT_SIZE = 30000000;

    private K[] key;
    private V[] value;
    private Boolean[] isEnable;
    private int arraySize;


    public HashMap_Original(){
        createHashMap(DEFAULT_SIZE);
    }

    public HashMap_Original(int size){
        createHashMap(size);
    }

    // put
    public void put(K key, V value){
        int hashCode = getHashCode(key);
        this.key[hashCode] = key;
        this.value[hashCode] = value;
        this.isEnable[hashCode] = true;
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
        this.key = k;

        V[] v = (V[])new Object[size];
        this.value = v;

        this.isEnable = new Boolean[size];

        this.arraySize = size;
    }

    private int getHashCode(K key){
        /*
        HashCodeを取得する。キー衝突時は、HashCodeを+1する
         */
        int hashCode = key.hashCode() % this.arraySize;
        while(true){
            if(this.isEnable[hashCode] != null){
                if(this.key == key) {
                    break;
                } else {
                    hashCode++;
                }
            } else {
                break;
            }
        }
        return hashCode;
    }
}

