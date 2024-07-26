document.addEventListener('DOMContentLoaded', function () {
    const navItems = document.querySelectorAll('.nav-item');

    // 기본값 설정 (식재료)
    const defaultNavItem = document.querySelector('.nav-item[data-target="ingredient"]');
    defaultNavItem.classList.add('default');

    navItems.forEach(item => {
        if (!item.classList.contains('default')) {
            item.classList.add('inactive');
        }
        
        item.addEventListener('click', () => {
            // 모든 항목의 활성 클래스 제거
            navItems.forEach(nav => nav.classList.remove('default', 'inactive'));

            // 클릭된 항목에 활성 클래스 추가
            item.classList.add('default');
            navItems.forEach(nav => {
                if (!nav.classList.contains('default')) {
                    nav.classList.add('inactive');
                }
            });
        });
    });
});
