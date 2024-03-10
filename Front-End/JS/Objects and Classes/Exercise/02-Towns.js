function towns(arr) {

    let obj = [];

    for (let i = 0; i < arr.length; i++) {
       let [townName, latitude, longitude] = arr[i].split(" | ");

        let town = {
            town: townName,
            latitude: Number(latitude).toFixed(2),
            longitude: Number(longitude).toFixed(2),
        }

        obj.push(town);
    }

    obj.forEach((e) => console.log(e));

}