import hashmap_test.HashMap_Original;

import java.util.Random;

public class main {
    public static void main(String[] args) {
        /*
        // テスト
        HashMap_Original<String, String> test = new HashMap_Original();
        // put/getテスト
        test.put("a","b");
        test.put("b","e");
        System.out.println("put後(b)→" + test.get("a"));
        System.out.println("put後(e)→" + test.get("b"));
        System.out.println("putしていないキーだと→" + test.get("aa"));
        test.put("a","d");
        System.out.println("上書き後(d)→" + test.get("a"));
        // removeテスト
        test.remove("a");
        System.out.println("消去後→" + test.get("a"));

        // Int型でも動作するか確認
        HashMap_Original<Integer, String> test2 = new HashMap_Original();
        test2.put(1,"a");
        System.out.println("put後→" + test2.get(1));
        test2.remove(1);
        System.out.println("消去後→" + test2.get(1));
        test2.put(1,"cc");
        System.out.println(test2.get(1));
        System.out.println(test2.get(2));
        */


        // ここから性能調査
        HashMap_Original<String, String> hashmapStrStr;
        HashMap_Original<Integer, Integer> hashmapIntInt;
        HashMap_Original<Random, Random> hashmapRndRnd;

        long start_time;
        // <String/String>
        System.out.println("<String,String>のテスト");
        hashmapStrStr = new HashMap_Original();
        System.out.println("１．100万回登録");
        start_time = System.currentTimeMillis();
        for(int i=0; i<1000000; i++){
            long end_time;
            Random rnd = new Random();
            String ran = Integer.toString(rnd.nextInt(100000000));
            hashmapStrStr.put(ran, ran);
            if(i % 100000 == 0){
                end_time = System.currentTimeMillis();
                System.out.println("i=" + i + " => time:" + (end_time - start_time) + "ms");
            }
        }

        // １００万回読み込みのためのデータ準備(keyが1-1000000のデータ作る)
        // ハッシュテーブル再生成のテストも込み
        hashmapStrStr = new HashMap_Original(6000000);
        for(int i=0; i<1000000; i++){
            String str = Integer.toString(i);
            hashmapStrStr.put(str, str);
        }

        System.out.println("2．100万回読み込み");
        start_time = System.currentTimeMillis();
        for(int i=0; i<1000000; i++){
            long end_time;
            Random rnd = new Random();
            String ran = Integer.toString(rnd.nextInt(1000000));
            String result = hashmapStrStr.get(ran);
            if(result == null){
                System.out.println("検索結果がNullはありえない！ ran=" + ran);
            }
            if(i % 100000 == 0){
                end_time = System.currentTimeMillis();
                System.out.println("i=" + i + " => time:" + (end_time - start_time) + "ms");
            }
        }

        // <Integer/Integer>
        System.out.println("１．100万回登録");
        hashmapIntInt = new HashMap_Original();
        start_time = System.currentTimeMillis();
        for(int i=0; i<1000000; i++){
            long end_time;
            Random rnd = new Random();
            int ran = rnd.nextInt(100000000);
            hashmapIntInt.put(ran, ran);
            if(i % 100000 == 0){
                end_time = System.currentTimeMillis();
                System.out.println("i=" + i + " => time:" + (end_time - start_time) + "ms");
            }
        }
        // １００万回読み込みのためのデータ準備(keyが1-1000000のデータ作る)
        hashmapIntInt = new HashMap_Original();
        for(int i=0; i<1000000; i++){
            int num = i;
            hashmapIntInt.put(num, num);
        }
        System.out.println("2．100万回読み込み");
        start_time = System.currentTimeMillis();
        for(int i=0; i<1000000; i++){
            long end_time;
            Random rnd = new Random();
            int ran = rnd.nextInt(1000000);
            int result = hashmapIntInt.get(ran);
            if(i % 100000 == 0){
                end_time = System.currentTimeMillis();
                System.out.println("i=" + i + " => time:" + (end_time - start_time) + "ms");
            }
        }

        // <Random/Random> (任意のクラス）
        System.out.println("<Random,Random>のテスト（任意のクラス）");
        System.out.println("１．100万回登録");
        hashmapRndRnd = new HashMap_Original();
        start_time = System.currentTimeMillis();
        for(int i=0; i<1000000; i++){
            long end_time;
            Random rnd = new Random(i);
            hashmapRndRnd.put(rnd, rnd);
            if(i % 100000 == 0){
                end_time = System.currentTimeMillis();
                System.out.println("i=" + i + " => time:" + (end_time - start_time) + "ms");
            }
        }
        // １００万回読み込みのためのデータ準備(keyが1-1000000のデータ作る)
        hashmapIntInt = new HashMap_Original();
        for(int i=0; i<1000000; i++){
            Random rnd = new Random(i);
        }
        System.out.println("2．100万回読み込み");
        start_time = System.currentTimeMillis();
        for(int i=0; i<1000000; i++){
            long end_time;
            Random rnd = new Random(i);
            hashmapRndRnd.get(rnd);
            if(i % 100000 == 0){
                end_time = System.currentTimeMillis();
                System.out.println("i=" + i + " => time:" + (end_time - start_time) + "ms");
            }
        }

    }
}
