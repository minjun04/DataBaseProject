package DataBaseProject.demo.domain.Entity.application;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class StudyApplicationId implements Serializable {
    private int applicationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudyApplicationId)) return false;
        StudyApplicationId that = (StudyApplicationId) o;
        return applicationId == that.applicationId &&
                groupId == that.groupId &&
                Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, studentId, groupId);
    }
}
