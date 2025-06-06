    document.getElementById("computerBtn").addEventListener("click", function() {
        document.getElementById("subCategories").style.display = "flex";
        document.getElementById("studyGroups").style.display = "flex";


            fetch('/select/study/topTopic')
                .then(response => response.json())
                .then(data => {
                    const studyList = document.getElementById("studyGroups");
                    data.forEach(group => {
                        const card = document.createElement("div");
                        card.className = "study-card";
                        card.innerHTML = `
                            <img src="${group.imageUrl}" alt="${group.topic}">
                            <div>${group.groupName} | ${group.topic} | ${group.leaderName}</div>
                            <div>${group.activityDay} ${group.activityTime} | 인원 ${group.maxMember}명</div>
                            <button>신청하기</button>
                        `;
                        studyList.appendChild(card);
                    });
                })
                .catch(error => console.error('에러 발생:', error));

    });
