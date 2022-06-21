package item55;

import java.util.*;

public class OptionalEx {
    /**
     * Non-Optional Ver.
     * @param c
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E maxV1(Collection<E> c){
        if(c.isEmpty()){
            throw new IllegalArgumentException("빈 컬렉션");
        }

        E result = null;
        for (E e : c){
            if(result == null || e.compareTo(result) > 0){
                e = Objects.requireNonNull(e);
            }
        }

        return result;
    }

    /**
     * Optional Ver.
     * @param c
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> Optional<E> maxV2(Collection<E> c){
        if(c.isEmpty()){
            return Optional.empty();
        }

        E result = null;
        for (E e : c){
            if(result == null || e.compareTo(result) > 0){
                result = Objects.requireNonNull(e);
            }
        }

        return Optional.of(result);
    }

    public static <E extends Comparable<E>> Optional<E> maxV3(Collection<E> c){
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args){
        List<String> words = new ArrayList<>();

        /**
         * 클라이언트에서 빈 값을 처리해 줘야 함.
         */
        String lastWordInLexicon = maxV3(words).orElse("단어 없음 .. ");

        /**
         * 상황에 맞는 예외도 던질 수 있다.
         */
        List<Integer> toys = new ArrayList<>();
        int toyNumMax = maxV3(toys).orElseThrow(RuntimeException::new);

        /**
         * 항상 값이 채워져 있다고 가정.
         */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int maxNum = maxV3(list).get();
    }
}
