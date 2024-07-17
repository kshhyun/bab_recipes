document.addEventListener('DOMContentLoaded', () => {
    const navItems = document.querySelectorAll('nav ul li');

    navItems.forEach(item => {
        item.addEventListener('click', () => {
            // 모든 항목에서 selected 클래스 제거
            navItems.forEach(i => i.classList.remove('selected'));
            // 클릭된 항목에 selected 클래스 추가
            item.classList.add('selected');
        });
    });
});
