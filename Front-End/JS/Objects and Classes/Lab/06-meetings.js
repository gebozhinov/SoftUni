function meetings(arr) {

    let map = new Map();

    for (let i = 0; i < arr.length; i++) {
        let weekday = arr[i].split(" ")[0];
        let name = arr[i].split(" ")[1];

        if (!map.has(weekday)) {
            map.set(weekday, name);
            console.log(`Scheduled for ${weekday}`)
        } else {
            console.log(`Conflict on ${weekday}!`)
        }
    }

    map.forEach((value, key) => {
            console.log(`${key} -> ${value}`)
    })

}