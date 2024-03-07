function addressBook(arr) {

    let map = new Map();

    for (let i = 0; i < arr.length; i++) {
        let name = arr[i].split(":")[0];
        let address = arr[i].split(":")[1];

        map.set(name, address);
    }

    let sortedMap = new Map([...map.entries()].sort());
    sortedMap.forEach((value, key) => {
        console.log(`${key} -> ${value}`)
    })
}