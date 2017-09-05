package hashmap_test;

public class HashMap_Original<K,V> {

    // HashMapのKey,Value,有効フラグ
    private int DEFAULT_SIZE = 30000000;

    private K[] key;
    private V[] value;
    private Boolean[] isEnable;
    private int arraySize;

    private int isEnableCount;

    public HashMap_Original(){
        createHashTable(DEFAULT_SIZE);
    }

    public HashMap_Original(int size){
        createHashTable(size);
    }

    // put
    public void put(K key, V value){
        int hashCode = getHashCode(key);
        this.key[hashCode] = key;
        this.value[hashCode] = value;
        if(this.isEnable[hashCode] == null) {
            this.isEnable[hashCode] = true;
            this.isEnableCount++;
        }
        // ハッシュテーブルの使用率が１０％を超えたら拡張する。
        if(this.isEnableCount > this.arraySize / 10) {
            reCreateHashTable();
        }
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

    private void createHashTable(int size){
        @SuppressWarnings("unchecked")
        K[] k = (K[])new Object[size];
        this.key = k;

        V[] v = (V[])new Object[size];
        this.value = v;

        this.isEnable = new Boolean[size];

        this.arraySize = size;

        this.isEnableCount = 0;
    }

    private void reCreateHashTable(){
        K[] temp_key = (K[])new Object[this.arraySize];
        V[] temp_value = (V[])new Object[this.arraySize];
        Boolean[] temp_isEnable = new Boolean[this.arraySize];

        // Key,Valueを退避しておく
        System.arraycopy(this.key,0,temp_key,0,this.arraySize);
        System.arraycopy(this.value,0,temp_value,0,this.arraySize);
        System.arraycopy(this.isEnable,0,temp_isEnable,0,this.arraySize);

        // 領域を２倍にしたテーブルを作成する
        this.arraySize *= 2;
        createHashTable(this.arraySize);

        // 退避したKey,Valueを再度格納する
        for(int i=0;i<temp_isEnable.length;i++){
            if(temp_isEnable[i] != null){
                put(temp_key[i], temp_value[i]);
            }
        }
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
