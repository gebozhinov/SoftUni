function makeADictionary(arr) {

    let obj = {};

    for (const element of arr) {
        let currentObj = JSON.parse(element);

        Object.keys(currentObj).forEach(term => {
            obj[term] = currentObj[term];
        })
    }

    const sortedArr = Object.entries(obj)
    .sort(([termA], [termB]) => termA.localeCompare(termB));

    const sortedObj = Object.fromEntries(sortedArr);

    for (const [key, value] of Object.entries(sortedObj)) {
        console.log(`Term: ${key} => Definition: ${value}`)
    }
}