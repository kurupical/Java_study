import test.HelloWorld;
import java.util.HashMap;
import java.util.Random;
import java.util.Iterator;

public class test_main {
    public static void main(String[] args){

        // チュートリアル
        HelloWorld hw = new HelloWorld();

        // HashMapの性能調査
        HashMap<String, String> hashmap = new HashMap<String, String>();
        System.out.println(hashmap.get("apple"));
        long start = System.currentTimeMillis();

        for(int i=0; i<1000000; i++){
            long end;
            Random rnd = new Random();
            String ran = Integer.toString(rnd.nextInt(1000000));
            hashmap.put(ran, ran);
            if(i % 100000 == 0){
                end = System.currentTimeMillis();
                System.out.println("i=" + i + "time:" + (end - start) + "ms");
            }
        }

        start = System.currentTimeMillis();

        Iterator entries = hashmap.entrySet().iterator();
        int i=0;
        while(entries.hasNext()){
            long end;
            HashMap.Entry entry = (HashMap.Entry)entries.next();
            hashmap.get((String)entry.getKey());
            if(i % 100000 == 0){
                end = System.currentTimeMillis();
                System.out.println("i=" + i + "time:" + (end - start) + "ms");
            }
            i++;
        }

        // HashMapって何ができるの？
        // keyを変なクラスにしてやる
        HashMap<Random, Random> hashmap2 = new HashMap<Random, Random>();
        Random test = new Random();
        System.out.println(test);
        start = System.currentTimeMillis();
        for(i=0; i<1000000; i++){
            long end;
            Random rnd = new Random();
            hashmap2.put(rnd, rnd);
            if(i % 100000 == 0){
                end = System.currentTimeMillis();
                System.out.println("i=" + i + "time:" + (end - start) + "ms");
            }
        }

        // 配列に値を代入することにかかる時間の計測
        start = System.currentTimeMillis();
        int[] ary = new int[1000000];
        for(int k=0; k<1000000; k++){
            long end;
            ary[k] = k;
            if(k % 100000 == 0){
                end = System.currentTimeMillis();
                System.out.println("k=" + k + "time:" + (end - start) + "ms");
            }
        }

        // 100万行の配列をずらすことにかかる時間の計測
        start = System.currentTimeMillis();
        for(int k=0; k<1000; k++){
            long end;
            System.arraycopy(ary,0,ary,1,ary.length-1);
            if(k % 100 == 0){
                end = System.currentTimeMillis();
                System.out.println("k=" + k + "time:" + (end - start) + "ms");
            }
        }

        // 100万行を頭から検索するのにかかる時間の計測
        start = System.currentTimeMillis();
        for(int k=0; k<1000000; k++){
            if(k == ary[k]){
                //何もしない
            }
        }
        long end;
        end = System.currentTimeMillis();
        System.out.println("time:" + (end - start) + "ms");

        // HashCode取得
        String eng = "APPLE";
        String jpn = "りんご";
        System.out.println(eng.hashCode());

        // 配列
        int[] ts = new int[5];
        ts[0] = 1;
        ts[1] = 0;
        ts[2] = 3;
        System.out.println(ts[1]);
        System.out.println(ts[0]);
        int aaa = 1;
        Boolean[] bl = new Boolean[2];


        System.out.println(bl[0]);
        System.out.println((bl[0] == null));
        bl[0] = true;
        System.out.println((bl[0] == null));
        bl[0] = null;
        System.out.println((bl[0] == null));

        String[] strrr = new String[3];
        strrr[2] = "a";
        System.out.println(strrr[2]);
        strrr = new String[10];
        strrr[3] = "ee";
        System.out.println(strrr[2]);
        System.out.println(strrr[3]);

        // hash
        String cm1 = "test";
        String cm2 = "test";
        String cm3 = "ts";

        System.out.println((cm1.compareTo(cm2)));
        System.out.println((cm1.compareTo(cm3)));
    }
}
