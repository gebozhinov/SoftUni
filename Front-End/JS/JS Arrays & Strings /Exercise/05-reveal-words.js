function revealWords(words, text) {

    let wordsToArr = words.split(", ");
    let textToArr = text.split(" ");
    for (let i = 0; i < wordsToArr.length; i++) {
        let wordsToReveal = wordsToArr[i];
        for (let j = 0; j < textToArr.length; j++) {
            let currentWord = textToArr[j];
            if (currentWord.includes("*") && currentWord.length == wordsToReveal.length) {
                textToArr[j] = wordsToReveal;
            }
        }
    }
    console.log(textToArr.join(" "))

}