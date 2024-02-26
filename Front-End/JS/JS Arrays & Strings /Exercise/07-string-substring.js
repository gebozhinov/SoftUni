function findAWord(word, text) {
    let lowercaseText = text.toLowerCase().split(" ");

    for (let i = 0; i < lowercaseText.length; i++) {
        let currentWord = lowercaseText[i];
        if (word === currentWord) {
            console.log(word);
            return;
        }
    }

    console.log(`${word} not found!`)
}