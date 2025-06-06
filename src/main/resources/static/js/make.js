document.getElementById("createBtn").addEventListener("click", function() {
    const studentId = document.getElementById("studentId").value;
    const studyName = document.getElementById("studyName").value;
    const topTopic = document.getElementById("topTopic").value;
    const topic = document.getElementById("topic").value;
    const maxMember = parseInt(document.getElementById("maxMember").value);
    const activityTimeInput = document.getElementById("activityTime").value.trim();

    const parts = activityTimeInput.split(" ");
    if (parts.length < 2) {
        alert("활동시간은 '요일 시간' 형식으로 입력하세요. 예: 월요일 18:00");
        return;
    }
    const activityDay = parts[0];
    const activityTime = parts[1];

    const requestData = {
        studentId, studyName, topTopic, topic, activityDay, activityTime, maxMember,
    };

    fetch('/make/study', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(requestData)
    })
    .then(res => {
        if (res.ok) {
            alert("생성이 완료되었습니다.");
            window.location.href = "/myPage";
        } else {
            alert("생성 실패");
        }
    })
    .catch(error => {
        console.error("에러 발생:", error);
        alert("생성 중 오류가 발생했습니다.");
    });
});
