document.addEventListener("DOMContentLoaded", function() {
  console.log("DOMContentLoaded - JS 실행됨");

  const form = document.getElementById("login-form");
  console.log("폼 찾음:", form);

  form.addEventListener("submit", function(e) {
    e.preventDefault();

    const student_id = document.getElementById("student_id").value;
    console.log("입력한 student_id:", student_id);

    fetch("/api/login", {
      method: "POST",
      headers: { "Content-Type": "text/plain" },
      body: student_id
    })
    .then(res => res.json())
    .then(data => {
      console.log("서버 응답 받음:", data);
      if (data.success) {
        window.location.href = "/index_main";
      } else {
        alert("로그인 실패");
      }
    });
  });
});
