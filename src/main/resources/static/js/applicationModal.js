const applications = {
  "김민상": {
    name: "김민상",
    major: "국방디지털융합학과",
    grade: "3학년",
    reason: "안녕하세요. 저는 인공지능 분야에 관심이 많아서 이 스터디에 지원하게 되었습니다. 열심히 하겠습니다!"
  },
  "손정민": {
    name: "김민기",
    major: "디지털미디어학과",
    grade: "3학년",
    reason: "국방디지털융합 분야에서 실력을 키우고 싶어 지원합니다. 많은 것을 배우고 싶습니다."
  },
  "박현민": {
    name: "박현민",
    major: "국방디지털융합학과",
    grade: "3학년",
    reason: "다양한 프로젝트 경험을 쌓기 위해 신청했습니다. 팀원들과 잘 협력하겠습니다."
  },
  "석원령": {
    name: "김민식",
    major: "소프트웨어학과",
    grade: "2학년",
    reason: "저의 부족한 부분을 채우고 싶습니다. 열심히 배우고 기여하겠습니다."
  }
};

function showReservationTable() {
    document.getElementById('reservation-table').style.display = 'block';
}
function openApplication(name) {
  const modal = document.getElementById("applicationModal");
  const title = document.getElementById("modalTitle");
  const info = applications[name];

  document.getElementById("infoName").innerText = info.name;
  document.getElementById("infoMajor").innerText = info.major;
  document.getElementById("infoGrade").innerText = info.grade;
  document.getElementById("modalContent").innerText = info.reason;

  modal.style.display = "flex";
}

function closeModal() {
  const modal = document.getElementById("applicationModal");
  modal.style.display = "none";
}

function approveApplication() {
    // 승인 로직 작성
    alert("신청서가 승인되었습니다.");
    closeModal();
}

function rejectApplication() {
    // 거절 로직 작성
    alert("신청서가 거절되었습니다.");
    closeModal();
}

function closeModal() {
    document.getElementById('applicationModal').style.display = 'none';
}