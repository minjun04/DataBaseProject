package DataBaseProject.demo.domain.Entity.studySchedule;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class StudyScheduleId implements Serializable {
    private int scheduleId;
    private String leaderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudyScheduleId)) return false;
        StudyScheduleId that = (StudyScheduleId) o;
        return scheduleId == that.scheduleId &&
                Objects.equals(leaderId, that.leaderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, leaderId);
    }
}
