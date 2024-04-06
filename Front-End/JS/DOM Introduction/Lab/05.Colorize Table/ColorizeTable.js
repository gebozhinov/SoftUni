function colorize() {
    let rows = document.getElementsByTagName('tr');
    for (let i = 0; i < rows.length; i++) {
        if (i % 2 !== 0) {
            rows[i].style.background = 'teal';
        }
    }
}