document.addEventListener("DOMContentLoaded", function () {
    const computerBtn = document.getElementById("computerBtn");
    const subCategories = document.getElementById("subCategories");
    const studyGroups = document.getElementById("studyGroups");

    // 컴퓨터 버튼 클릭 시 하위 카테고리 보여주기
    computerBtn.addEventListener("click", function () {
        subCategories.style.display = "flex";
        studyGroups.style.display = "flex";

        // 여기에 컴퓨터 버튼 눌렀을 때 DB에서 topTopic = 컴퓨터 조회하는 fetch 추가 가능
        fetch(`/select/study/topTopic?topTopic=컴퓨터`)
            .then(response => response.json())
            .then(data => {
                renderStudyGroups(data);
            })
            .catch(error => {
                console.error("JSON 파싱 에러:", error);
            });
    });

    // 각 하위 카테고리 버튼 클릭 시 서버 요청
    const subCategoryButtons = subCategories.querySelectorAll("button");
    subCategoryButtons.forEach(button => {
        button.addEventListener("click", function () {
            const selectedTopic = button.getAttribute("data-topic");

            fetch(`/select/study/topic?topic=${encodeURIComponent(selectedTopic)}`)
                .then(response => response.json())
                .then(data => {
                    renderStudyGroups(data);

                })
                .catch(error => {
                    console.error("JSON 파싱 에러:", error);
                });
        });
    });

    // 스터디 그룹 목록 렌더링 함수
    function renderStudyGroups(groups) {
        studyGroups.innerHTML = ""; // 기존 목록 초기화

        groups.forEach(group => {
            const card = document.createElement("div");
            card.className = "study-card";
            card.innerHTML = `
                <h3>${group.groupName}</h3>
                <p>주제: ${group.topic}</p>
                <p>리더: ${group.leaderName}</p>
                <p>요일: ${group.activityDay} 시간:${group.activityTime}</p>
                <p>인원: ${group.maxMember}명</p>
                <button class="apply-btn">신청하기</button>
            `;

            studyGroups.appendChild(card);

            // 여기서 단순히 페이지 이동만 수행
            const applyButton = card.querySelector(".apply-btn");
            applyButton.addEventListener("click", function () {
                window.location.href = "/studyApply";  // 이동할 페이지 경로만 지정
            });
        });
    }
});
