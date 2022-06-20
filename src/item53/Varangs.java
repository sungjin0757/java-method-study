package item53;

import java.util.Arrays;

public class Varangs {
    public static int sum(int... args){
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    // 인수를 0개만 넣어 호출하면 런타임에 싫패한다.
    public static int minV1(int... args){
        if (args.length == 0){
            throw new IllegalArgumentException("인수가 1개 이상 필요합니다.");
        }
        return Arrays.stream(args).min().getAsInt();
    }

    // 인수가 1개 이상이어야만 할 때 가변인수를 사용하는 방법.
    public static int minV2(int firstArg, int... remainingArgs){
        return Math.min(firstArg, Arrays.stream(remainingArgs).min().getAsInt());
    }
}
