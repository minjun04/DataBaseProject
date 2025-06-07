// studyroom.js

document.addEventListener('DOMContentLoaded', function() {
    const searchButton = document.querySelector('.search-btn');
    const studyInput = document.querySelector('.study-input');
    const reservationTable = document.getElementById('reservation-table');

    searchButton.addEventListener('click', function() {
        const inputValue = studyInput.value.trim();

        if (inputValue === '') {
            alert('스터디명을 입력해주세요.');
            return;
        }

        reservationTable.style.display = 'block';
    });
});
