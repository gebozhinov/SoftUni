function count(text, searchedWord) {
    let words = text.split(" ");
    let count = 0;
    for (let word of words) {
        if (word === searchedWord) {
            count += 1;
        }
    }

    console.log(count);
}