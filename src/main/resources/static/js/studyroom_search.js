<script>
document.addEventListener("DOMContentLoaded", function() {
    // 조회 버튼 클릭 시 테이블 표시
    const searchBtn = document.querySelector(".search-btn");
    const studyInput = document.querySelector(".study-input");
    const tableBox = document.getElementById("reservation-table");

    searchBtn.addEventListener("click", function() {
        const studyName = studyInput.value.trim();
        if (studyName !== "") {
            tableBox.style.display = "block";
        } else {
            alert("스터디명을 입력해주세요.");
        }
    });
});
</script>
