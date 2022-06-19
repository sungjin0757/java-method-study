package item49;

public class AssertEx {
    //assert를 사용해 매개변수 유효성을 검증할 수 있다.

    /**
     * 단언문이 실패하면 AssertionError를 던진다.
     * 런타임에 아무런 효과도, 아무런 성능 저하도 없다.
     */
    private static void sort(long[] a, int offset, int length){
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
    }
}
