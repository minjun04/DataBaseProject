document.addEventListener("DOMContentLoaded", function() {
       const menus = document.querySelectorAll(".menu");

       menus.forEach(menu => {
           menu.addEventListener("click", function(e) {
               e.stopPropagation();

               const submenu = menu.querySelector(".submenu");
               if (submenu) {
                   submenu.style.display = (submenu.style.display === "block") ? "none" : "block";
               }

               const submenu2 = menu.querySelector(".submenu2");
               if (submenu2) {
                   submenu2.style.display = (submenu2.style.display === "block") ? "none" : "block";
               }
           });
       });
});