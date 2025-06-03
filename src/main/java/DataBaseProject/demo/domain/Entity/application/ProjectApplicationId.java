package DataBaseProject.demo.domain.Entity.application;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectApplicationId implements Serializable {

    private String studentId;
    private int projectId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectApplicationId)) return false;
        ProjectApplicationId that = (ProjectApplicationId) o;
        return projectId == that.projectId &&
                Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, projectId);
    }
}
