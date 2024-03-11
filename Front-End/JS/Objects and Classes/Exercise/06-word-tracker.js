function wordTracker(arr) {

    let wordsToFind = arr[0].split(" ");
    let wordsToCheck = arr.slice(1);

    let words = [];
    for (let i = 0; i < wordsToFind.length; i++) {
        let currentWord = wordsToFind[i];

        let wordObj = {
            word: currentWord,
            occurs: 0,
        }

        words.push(wordObj);
    }

    for (let i = 0; i < wordsToCheck.length; i++) {
        let currentWord = wordsToCheck[i];

        words.forEach(word => {

            if (Object.values(word).includes(currentWord)) {
                word["occurs"]++;
            }

        })

    }

    words.sort((a, b) => b.occurs - a.occurs);
    words.forEach(word => console.log(`${word.word} - ${word.occurs}`));

}