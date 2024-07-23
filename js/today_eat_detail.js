function toggleBookmark() {
    var bookmarkIcon = document.getElementById('bookmark-icon');
    if (bookmarkIcon.src.includes('bookmark.png')) {
        bookmarkIcon.src = 'images/bookmark_filled.png';
    } else {
        bookmarkIcon.src = 'images/bookmark.png';
    }
}