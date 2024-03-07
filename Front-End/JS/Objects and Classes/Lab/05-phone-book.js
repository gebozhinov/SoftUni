function phoneBook(arr) {

    let map = new Map();

    for (let i = 0; i < arr.length; i++) {
        let name = arr[i].split(" ")[0];
        let phone = arr[i].split(" ")[1];

        map.set(name, phone);

    }

    map.forEach((value, key) => {
        console.log(`${key} -> ${value}`);
    })
}