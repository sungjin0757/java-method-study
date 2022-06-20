package item50;

import java.util.Date;

public class PeriodWithDefenseV2 {
    private final Date start;
    private final Date end;

    /**
     * 외부 공격에서 보호하기 위해 생성자에서 받은 가변 매개변수 각각을 방어적으로 복사 해야 한다.
     */
    public PeriodWithDefenseV2(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(this.start.compareTo(this.end) > 0){
            throw new IllegalArgumentException(start+"가 "+end+"보다 늦어야 합니다.");
        }
    }

    // 방어적 복사본을 만들어 반환
    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }
}
