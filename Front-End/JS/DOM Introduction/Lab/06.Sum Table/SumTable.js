function sumTable() {
    let rows = document.getElementsByTagName('tr');

    let sum = 0;
    for (let i = 1; i < rows.length - 1; i++) {
        let cells = rows[i].children;
        let price = Number(cells[1].textContent);
        sum += price;
    }
    document.getElementById('sum').textContent = sum;
}