function piccolo(arr) {


    let parking = [];

    for (let i = 0; i < arr.length; i++) {
        let [direction, number] = arr[i].split(", ");

        switch (direction) {
            case "IN":
                if (!parking.includes(number)) {
                    parking.push(number);
                }
                break;
            case "OUT":
                if (parking.includes(number)) {
                    let index = parking.indexOf(number);
                    parking.splice(index, 1);
                }
                
                break;
        }
    }

    if (parking.length === 0) {
        console.log("Parking Lot is Empty")
    } else {
        parking.sort((a, b) => a.localeCompare(b)).forEach(car => console.log(car));
    }
}