package DataBaseProject.demo.domain.Entity.studyRoom;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class StudyRoomId {
    private String buildingName;
    private String roomNumber;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudyRoomId)) return false;
        StudyRoomId that = (StudyRoomId) o;
        return Objects.equals(buildingName, that.buildingName) &&
                Objects.equals(roomNumber, that.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingName, roomNumber);
    }
}
