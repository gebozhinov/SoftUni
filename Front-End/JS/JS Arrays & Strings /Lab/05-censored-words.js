function censored(sentence, word) {
    let regex = new RegExp((word), 'g');
    let rep = "*".repeat(word.length);

    console.log(sentence.replace(regex, rep));
}
