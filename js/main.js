document.addEventListener('DOMContentLoaded', function() {
    const navItems = document.querySelectorAll('.nav-item');
    const contentSections = document.querySelectorAll('.content');

    navItems.forEach(item => {
        item.addEventListener('click', function() {

            navItems.forEach(nav => nav.classList.remove('active'));
            this.classList.add('active');

            contentSections.forEach(section => section.classList.remove('active'));
            const target = this.getAttribute('data-target');
            document.getElementById(target).classList.add('active');
        });
    });

    document.querySelector('.nav-item[data-target="western"]').classList.add('active');
    document.getElementById('western').classList.add('active');
});
