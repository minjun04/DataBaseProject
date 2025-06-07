// 하드코딩된 신청서 데이터
const applications = {
  "김민상": "안녕하세요. 저는 인공지능 분야에 관심이 많아서 이 스터디에 지원하게 되었습니다. 열심히 하겠습니다!",
  "손정민": "국방디지털융합 분야에서 실력을 키우고 싶어 지원합니다. 많은 것을 배우고 싶습니다.",
  "박현민": "다양한 프로젝트 경험을 쌓기 위해 신청했습니다. 팀원들과 잘 협력하겠습니다.",
  "석원령": "저의 부족한 부분을 채우고 싶습니다. 열심히 배우고 기여하겠습니다."
};

// 모달 열기 함수
function openApplication(name) {
  const modal = document.getElementById("applicationModal");
  const title = document.getElementById("modalTitle");
  const content = document.getElementById("modalContent");

  title.innerText = `${name}님의 신청서`;
  content.innerText = applications[name];
  modal.style.display = "flex";
}

// 모달 닫기 함수
function closeModal() {
  const modal = document.getElementById("applicationModal");
  modal.style.display = "none";
}
