// 예약 모달 열기
function openReservationModal() {
    const modal = document.getElementById("reservationModal");
    modal.style.display = "flex";
}

// 예약 모달 닫기
function closeReservationModal() {
    const modal = document.getElementById("reservationModal");
    modal.style.display = "none";
}

// 예약 확정 (지금은 확인만 띄움)
function confirmReservation() {
    alert("예약이 처리되었습니다.");
    closeReservationModal();
}
