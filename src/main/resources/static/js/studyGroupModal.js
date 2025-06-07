// 모달 열기
function openModal(groupName, members) {
  document.getElementById('groupName').textContent = groupName;

  const memberListDiv = document.getElementById('memberList');
  memberListDiv.innerHTML = '';

  members.forEach(member => {
    const div = document.createElement('div');
    div.textContent = `${member.name} (${member.major} / ${member.grade}학년 / ${member.phone})`;
    memberListDiv.appendChild(div);
  });

  document.getElementById('memberModal').style.display = 'flex';
}

// 모달 닫기
function closeModal() {
  document.getElementById('memberModal').style.display = 'none';
}

// 버튼별 하드코딩 데이터 정의
const studyGroups = [
  {
    groupName: '인공지능공부해요',
    members: [
      {name: "이서준", major: "국방디지털융합학과", grade: 1, phone: "010-2303-0303"},
      {name: "김민준", major: "소프트웨어학과", grade: 2, phone: "010-1234-5678"}
    ]
  },
  {
    groupName: 'AI스터디마스터',
    members: [
      {name: "박지민", major: "소프트웨어학과", grade: 3, phone: "010-3456-7890"},
      {name: "박현민", major: "국방디지털융합학과", grade: 2, phone: "010-9876-5432"},
      {name: "정현수", major: "사이버보안학과", grade: 4, phone: "010-7777-7777"},
      {name: "김민식", major: "사이버보안학과", grade: 3, phone: "010-1111-2222"}
    ]
  },
  {
    groupName: '고민준과 아이들2',
    members: [
    ]
  }
];

// 이벤트 위임 방식으로 버튼 이벤트 처리
document.addEventListener('click', function(event) {
  if (event.target.classList.contains('blue-btn')) {
    const buttons = Array.from(document.querySelectorAll('.blue-btn'));
    const index = buttons.indexOf(event.target);

    const data = studyGroups[index];
    openModal(data.groupName, data.members);
  }
});
