document.addEventListener("DOMContentLoaded", function () {

    localStorage.setItem("studentId", "202300023");
    const studentId = localStorage.getItem("studentId");

    // 내 정보 가져오기
    fetch(`/api/myStatus/info?studentId=${studentId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("프로필 응답 실패");
            }
            return response.json();
        })
        .then(data => {
            const profileBox = document.querySelector(".profile-box");
            profileBox.innerHTML = `
                <div>이름: ${data.name ?? ''}</div>
                <div>전공: ${data.major ?? ''}</div>
                <div>학년: ${data.grade ?? ''}</div>
                <div>전화번호: ${data.phone ?? ''}</div>
            `;
        })
        .catch(error => {
            console.error("프로필 데이터 불러오기 실패:", error);
        });

    // 스터디 그룹 가져오기
    fetch(`/api/myStatus/studyInfo?studentId=${studentId}`)
        .then(response => {
            if (response.status === 204) {
                return [];
            }
            return response.json();
        })
        .then(studyGroups => {
            if (!studyGroups) {
                studyGroups = [];
            }
            if (!Array.isArray(studyGroups)) {
                studyGroups = [studyGroups];
            }

            const studyTbody = document.querySelectorAll(".custom-table tbody")[0];
            studyTbody.innerHTML = "";

            studyGroups.forEach(group => {
                if (!group) return; // null 방어

                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${group.groupName ?? ''}</td>
                    <td>${group.activityDay ?? ''} ${group.activityTime ?? ''}</td>
                    <td>${group.location ?? ''}</td>
                    <td><button class="blue-btn">자세히 보기</button></td>
                `;
                studyTbody.appendChild(row);
            });
        })
        .catch(error => {
            console.error("스터디 그룹 데이터 불러오기 실패:", error);
        });

    const projects = [
           {
               name: "Software Masters",
               topic: "소프트웨어",
               createDate: "2025-01-15",
           }
       ];

       const projectTbody = document.querySelectorAll(".custom-table tbody")[1];
       projectTbody.innerHTML = "";

       projects.forEach(project => {
           if (!project) return;

           const row = document.createElement("tr");
           row.innerHTML = `
               <td>${project.name ?? ''}</td>
               <td>${project.topic ?? ''}</td>
               <td>${project.createDate ?? ''}</td>
               <td><button class="blue-btn" onclick="contactLeader('${project.leaderPhone ?? ''}')">연락처</button></td>
           `;
           projectTbody.appendChild(row);
       });
});
