function oddOccur(str) {

    let arr = str.toLowerCase().split(" ");

    let map = new Map();
    for (const word of arr) {
        if (map.has(word)) {
            let occurs = map.get(word);
            map.set(word, occurs + 1);
        } else {
            map.set(word, 1);
        }
    }

    let result = "";

    map.forEach((value, key) => {
        if (value % 2 !== 0) {
            result += key + " ";
        }
    });

    console.log(result.trim())
}