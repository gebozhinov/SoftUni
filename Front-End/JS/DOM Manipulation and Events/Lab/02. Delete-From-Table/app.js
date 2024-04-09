function deleteByEmail() {
    let inputElement = document.querySelector('input').value
    let elements = document.querySelectorAll('tr td');

    for (const row of elements) {
        if (inputElement === row.textContent) {
            parentRow = row.parentNode;
            parentRow.parentNode.removeChild(parentRow);
            document.getElementById('result').textContent = 'Deleted.';
            return;
        }
    }

    document.getElementById('result').textContent = 'Not found.';
}