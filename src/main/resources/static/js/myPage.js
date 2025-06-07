document.addEventListener("DOMContentLoaded", function () {

    const studentId = localStorage.getItem("studentId");
    fetch(`/mypage/${studentId}`)
        .then(response => response.json())
        .then(data => {
            // 내 정보 렌더링
            const profileBox = document.querySelector(".profile-box");
            profileBox.innerHTML = `
                <div>${data.student.name}</div>
                <div>${data.student.major}</div>
                <div>${data.student.grade}</div>
                <div>${data.student.phone}</div>
            `;

            // 스터디 그룹 테이블 렌더링
            const studyTbody = document.querySelectorAll(".custom-table tbody")[0];
            studyTbody.innerHTML = ""; // 기존 데이터 제거

            data.studyGroups.forEach(group => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${group.groupName}</td>
                    <td>${group.schedule}</td>
                    <td>${group.location}</td>
                    <td><button class="blue-btn" onclick="viewStudyDetail('${group.groupId}')">자세히 보기</button></td>
                `;
                studyTbody.appendChild(row);
            });

            // 파란학기 테이블 렌더링
            const projectTbody = document.querySelectorAll(".custom-table tbody")[1];
            projectTbody.innerHTML = "";

            data.projects.forEach(project => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${project.projectName}</td>
                    <td>${project.major}</td>
                    <td>${project.grade}</td>
                    <td><button class="blue-btn" onclick="contactLeader('${project.leaderPhone}')">연락처</button></td>
                `;
                projectTbody.appendChild(row);
            });
        })
        .catch(error => {
            console.error("데이터 불러오기 실패:", error);
        });
});

// 상세보기, 연락처 예시 함수 (선택)
function viewStudyDetail(groupId) {
    window.location.href = `/study_detail/${groupId}`;
}

function contactLeader(phone) {
    alert(`리더 연락처: ${phone}`);
}
