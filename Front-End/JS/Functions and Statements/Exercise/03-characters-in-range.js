function charactersInRange(firstChar, secondChar) {
    let start =  Math.min(firstChar.charCodeAt(), secondChar.charCodeAt());
    let end = Math.max(firstChar.charCodeAt(), secondChar.charCodeAt());

    let result = [];
    for (let i = start + 1; i < end; i++) {
       result.push(String.fromCharCode(i));
    }

    console.log(result.join(" "))
}