package item50;

import java.util.Date;

/**
 * 불변식을 지키지 못한 클래스
 */
public class PeriodWithNotDefence {
    private final Date start;
    private final Date end;

    /**
     *
     * @param start 시작 시각
     * @param end 종료 시각; 시작 시각보다 뒤여야 한다.
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
     */
    public PeriodWithNotDefence(Date start, Date end){
        if(start.compareTo(end) > 0){
            throw new IllegalArgumentException(start+"가 "+end+"보다 늦어야 합니다.");
        }
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

}
