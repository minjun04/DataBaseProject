document.addEventListener("DOMContentLoaded", function() {
    const menus = document.querySelectorAll(".menu");

    menus.forEach(menu => {
        // 1단계: 메뉴 클릭시 submenu 열고 닫기
        menu.addEventListener("click", function(e) {
            e.stopPropagation();

            const submenu = menu.querySelector(".submenu");
            if (submenu) {
                submenu.style.display = (submenu.style.display === "block") ? "none" : "block";
            }
        });

        // 2단계: has-submenu 내부에서 submenu2 제어
        const hasSubmenu = menu.querySelector(".menu2");
        if (hasSubmenu) {
            const trigger = hasSubmenu.querySelector("span");
            const submenu2 = hasSubmenu.querySelector(".submenu2");

            trigger.addEventListener("click", function(e) {
                e.stopPropagation();
                submenu2.style.display = (submenu2.style.display === "block") ? "none" : "block";
            });
        }
    });
});
