package item50;

import java.util.Date;

public class PeriodClient {
    public static void main(String[] args){
        // Date 는 가변임.
        Date start = new Date();
        Date end = new Date();
        PeriodWithNotDefence p1 = new PeriodWithNotDefence(start, end);
        PeriodWithDefenseV1 p2 = new PeriodWithDefenseV1(start, end);
        PeriodWithDefenseV2 p3 = new PeriodWithDefenseV2(start, end);

        System.out.println(p1.getEnd());
        System.out.println(p2.getEnd());
        // end 의 내부를 수정
        end.setYear(78);
        System.out.println(p1.getEnd());
        System.out.println(p2.getEnd());

        // getter 를 통해 가변 필드를 변경할 수 있다.
        p2.getEnd().setYear(78);
        System.out.println(p2.getEnd());

    }
}
