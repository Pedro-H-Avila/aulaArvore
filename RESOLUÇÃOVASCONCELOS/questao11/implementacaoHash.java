import java.util.hashMap;
import java.util.hashSet;
import java.util.hashtable;
import java.util.linkedHashMap;
import java.util.concurrent.concurrentHashMap;
import java.util.treeMap;

public class implementacaoHash {
    public static void main( String[] args);{
    TreeMap <Integer, String> treeMap = new TreeMap<>();
    HashMap <Integer,String> hashMap = new HashMap<>();
    HashSet <String> hashSet = new HashSet<>();
    Hashtable <Integer,String> hashtable = new Hashtable<>();
    LinkedHashMap <Integer,String>linkedHashMap = new LinkedHashMap<>();
    ConcurrentHashMap <Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
    treeMap.put(1, "Pedro");
        treeMap.put(2, "Henrique");
            treeMap.put(3, "de");
                treeMap.put(4, "Avila");
                    treeMap.put(5, "Vasconcelos");

      System.out.println(treeMap);

    hashMap.put(1, "Pedro");
        hashMap.put(2, "Henrique");
            hashMap.put(3, "de");
                hashMap.put(4, "Avila");
                    hashMap.put(5, "Vasconcelos");
        System.out.println("Item que possui a chave 3: " + hashMap.get(3));

    hashSet.put( "Pedro");
        hashSet.put( "Henrique");
            hashSet.put( "de");
                hashSet.put("Avila");
                    hashSet.put( "Vasconcelos");
       
        System.out.println("Possui o item 'mamão'? " + hashSet.contains("mamão"));

    hashtable.put(1, "Pedro");
        hashtable.put(2, "Henrique");
            hashtable.put(3, "de");
                hashtable.put(4, "Avila");
                    hashtable.put(5, "Vasconcelos");

        System.out.println(hashtable);

    linkedHashMap.put(1, "Pedro");
        linkedHashMap.put(2, "Henrique");
            linkedHashMap.put(3, "de");
                linkedHashMap.put(4, "Avila");
                    linkedHashMap.put(5, "Vasconcelos");

        System.out.println(linkedHashMap);

 concurrentHashMap.put(1, "Pedro");
        concurrentHashMap.put(2, "Henrique");
            concurrentHashMap.put(3, "de");
                concurrentHashMap.put(4, "Avila");
                    concurrentHashMap.put(5, "Vasconcelos");

        System.out.println(concurrentHashMap);
    }

}