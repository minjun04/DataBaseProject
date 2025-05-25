package domain.Entity.Project;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectId implements Serializable {
    private String name;
    private String leaderId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectId)) return false;
        ProjectId that = (ProjectId) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(leaderId, that.leaderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, leaderId);
    }
}
