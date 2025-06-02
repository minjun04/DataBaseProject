package domain.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectApplicationId implements Serializable {
    private int applicationId;
    private String studentId;
    private int projectId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectApplicationId)) return false;
        ProjectApplicationId that = (ProjectApplicationId) o;
        return applicationId == that.applicationId &&
                projectId == that.projectId &&
                Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, studentId, projectId);
    }
}
