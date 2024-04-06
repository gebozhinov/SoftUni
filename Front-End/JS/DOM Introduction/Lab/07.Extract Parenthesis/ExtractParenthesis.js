function extract(content) {

    let text = document.getElementById(content).textContent;
    const regex = /\(([^)]+)\)/g;
    const matches = [];
    let match;
    while((match = regex.exec(text)) != null) {
        matches.push(match[1])
    }

    console.log(matches.join("; "))
    return matches.join("; ");

}