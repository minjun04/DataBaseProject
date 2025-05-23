package domain.Entity.Project;

import java.io.Serializable;
import java.util.Objects;

public class ProjectId implements Serializable {
    private String name;
    private String leaderId;

    public ProjectId() {}

    public ProjectId(String name, String leaderId) {
        this.name = name;
        this.leaderId = leaderId;
    }

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
