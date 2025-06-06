document.addEventListener("DOMContentLoaded", function () {
    const computerBtn = document.getElementById("computerBtn");
    const subCategories = document.getElementById("subCategories");
    const studyGroups = document.getElementById("studyGroups");
    const paginationDiv = document.getElementById("pagination");

    let allGroups = []; // 전체 데이터 저장
    const pageSize = 12;

    // 컴퓨터 버튼 클릭 시
    computerBtn.addEventListener("click", function () {
        subCategories.style.display = "flex";
        studyGroups.style.display = "flex";

        fetch(`/select/study/topTopic?topTopic=컴퓨터`)
            .then(response => response.json())
            .then(data => {
                allGroups = data;
                renderStudyGroups(1);
                renderPagination();
            })
            .catch(error => {
                console.error("JSON 파싱 에러:", error);
            });
    });

    // 하위 주제 버튼 클릭 시
    const subCategoryButtons = subCategories.querySelectorAll("button");
    subCategoryButtons.forEach(button => {
        button.addEventListener("click", function () {
            const selectedTopic = button.getAttribute("data-topic");

            fetch(`/select/study/topic?topic=${encodeURIComponent(selectedTopic)}`)
                .then(response => response.json())
                .then(data => {
                    allGroups = data;
                    renderStudyGroups(1);
                    renderPagination();
                })
                .catch(error => {
                    console.error("JSON 파싱 에러:", error);
                });
        });
    });

    function renderStudyGroups(pageNum) {
        studyGroups.innerHTML = "";

        const startIndex = (pageNum - 1) * pageSize;
        const endIndex = startIndex + pageSize;
        const currentGroups = allGroups.slice(startIndex, endIndex);

        currentGroups.forEach((group,index) => {
            const card = document.createElement("div");
            const imageIndex = (startIndex + index) % 17;
            const imageUrl = `/images/${imageIndex}.png`;
            card.className = "study-card";
            card.innerHTML = `
                <img src="${imageUrl}" class="study-image">
                <h3>${group.groupName}</h3>
                <p>주제: ${group.topic}</p>
                <p>리더: ${group.leaderName}</p>
                <p>요일: ${group.activityDay} 시간:${group.activityTime}</p>
                <p>인원: ${group.maxMember}명</p>
                <button class="apply-btn">신청하기</button>
            `;

            studyGroups.appendChild(card);

            const applyButton = card.querySelector(".apply-btn");
            applyButton.addEventListener("click", function () {
                window.location.href = "/studyApply";
            });

        });
    }

    function renderPagination() {
        paginationDiv.innerHTML = "";
        const totalPages = Math.ceil(allGroups.length / pageSize);

        for (let pageNum = 1; pageNum <= totalPages; pageNum++) {
            const pageButton = document.createElement("button");
            pageButton.textContent = pageNum;
            pageButton.addEventListener("click", function () {
                renderStudyGroups(pageNum);
            });
            paginationDiv.appendChild(pageButton);
        }
    }



        const menus = document.querySelectorAll(".menu");

        menus.forEach(menu => {
            const submenu = menu.querySelector(".submenu");
            if (submenu) {
                menu.addEventListener("click", function() {
                    submenu.style.display = (submenu.style.display === "block") ? "none" : "block";
                });
            }
        });

});
