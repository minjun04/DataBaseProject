document.addEventListener("DOMContentLoaded", function() {
        const menus = document.querySelectorAll(".has-submenu");

        menus.forEach(menu => {
            menu.addEventListener("click", function() {
                const submenu = menu.querySelector(".submenu");
                submenu.style.display = (submenu.style.display === "block") ? "none" : "block";
            });
        });
});