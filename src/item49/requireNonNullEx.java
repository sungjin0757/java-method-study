package item49;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class requireNonNullEx {
    private String strategy;

    public requireNonNullEx(String strategy) {
        this.strategy = Objects.requireNonNull(strategy, "전략");
    }

    static List<Integer> intArrayAsList(int[] a){
        // 이 검사를 통해서 null 값이 넘어오면 바로 NullPointerException 이 발생한다.
        // 만약 requireNonNull이 없으면 클라이언트가 돌려받은 List를 사용할 때 비로소 NullPointerException이 발생한다.
        // 즉, 추적이 어려워질 수 있다는 것을 뜻한다.

        Objects.requireNonNull(a);

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i];
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
