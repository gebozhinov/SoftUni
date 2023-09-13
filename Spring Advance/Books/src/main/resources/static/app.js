let loadBooksButton = document.getElementById("loadBooks")

loadBooksButton.addEventListener("click", onLoadBooks)

function onLoadBooks(event) {
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch("http://localhost:8080/api/books", requestOptions)
        .then(response => response.json())
        .then(json => json.forEach(book => {
            let authorsContainers = document.getElementById("authors-containers")

            let row = document.createElement("tr")

            let titleCol = document.createElement("td")
            let authorCol = document.createElement("td")
            let isbnCol = document.createElement("td")
            let actionCol = document.createElement("td")

            titleCol.textContent = book.title


            row.appendChild(titleCol)
            row.appendChild(authorCol)
            row.appendChild(isbnCol)
            row.appendChild(actionCol)

            authorsContainers.appendChild(row);

        }))
        .catch(error => console.log('error', error));
}