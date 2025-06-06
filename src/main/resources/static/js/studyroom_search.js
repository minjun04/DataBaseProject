<script>
document.addEventListener("DOMContentLoaded", function() {
    // 사이드바 서브메뉴 토글 (기존 코드 유지)
    const menus = document.querySelectorAll(".has-submenu");
    menus.forEach(menu => {
        menu.addEventListener("click", function() {
            const submenu = menu.querySelector(".submenu");
            submenu.style.display = (submenu.style.display === "block") ? "none" : "block";
        });
    });

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
