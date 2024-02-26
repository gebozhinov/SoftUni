function textSplit(text) {
    let regex = /[A-Z][a-z]*/gm;
    console.log(text.match(regex).join(", "));
}