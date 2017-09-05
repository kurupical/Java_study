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

    // remove
    public void remove(K key){
        int hashCode = getHashCode(key);
        this.isEnable[hashCode] = null;
    }

    // test
    public V get(K key) {
        int hashCode = getHashCode(key);
        if(this.isEnable[hashCode] != null){
            return this.value[hashCode];
        } else {
            return null;
        }

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

        int hashCode;
        if(key.hashCode() < 0){
            hashCode = (key.hashCode() * -1) % this.arraySize;
        } else {
            hashCode = key.hashCode() % this.arraySize;
        }
        while(true){
            if(this.isEnable[hashCode] != null){
                if (this.key[hashCode].equals(key)) {
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
