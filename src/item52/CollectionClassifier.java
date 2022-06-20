package item52;

import java.math.BigInteger;
import java.util.*;

public class CollectionClassifier {
    public static String classify(Set<?> s){
        return "집합";
    }

    public static String classify(List<?> lst){
        return "리스트";
    }

//    public static String classify(Collection<?> c){
//        return "그 외";
//    }

    public static String classify(Collection<?> c){
        return c instanceof Set ? "집합" :
                c instanceof List ? "리스트" : "그 외";
    }

    public static void main(String[] args){
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        // 그 외만 3번 나오게 된다.
        // 왜냐면 다중정의된 세 classify 중 어느 메서드를 호출할지가 컴파일 타임에 정해지기 때문이다.
        // 항상 collection<?> 타입이다.
        for (Collection<?> collection : collections) {
            System.out.println(classify(collection));
        }
    }
}
