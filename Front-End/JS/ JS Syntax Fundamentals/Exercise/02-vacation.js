function vacation(groupOfPeople, typeOfGroup, dayOfWeek) {

    let pricePerPerson;
    let totalPrice;
    switch (typeOfGroup) {
        case "Students":
            if (dayOfWeek === "Friday") {
                pricePerPerson = 8.45;
            } else if (dayOfWeek === "Saturday") {
                pricePerPerson = 9.80;
            } else {
                pricePerPerson = 10.46;
            }
            break;
        case "Business":
            if (dayOfWeek === "Friday") {
                pricePerPerson = 10.90;
            } else if (dayOfWeek === "Saturday") {
                pricePerPerson = 15.60;
            } else {
                pricePerPerson = 16;
            }
            break;
        case "Regular":
            if (dayOfWeek === "Friday") {
                pricePerPerson = 15;
            } else if (dayOfWeek === "Saturday") {
                pricePerPerson = 20;
            } else {
                pricePerPerson = 22.50;
            }
            break;
    }


    totalPrice = pricePerPerson * groupOfPeople;

    if (groupOfPeople >= 30 && typeOfGroup === "Students") {
        totalPrice *= 0.85;
    } else if (groupOfPeople >= 100 && typeOfGroup === "Business") {
        totalPrice -= pricePerPerson * 10;
    } else if (groupOfPeople >= 10 && groupOfPeople <= 20 && typeOfGroup === "Regular") {
        totalPrice *= 0.95;
    }

    console.log(`Total price: ${totalPrice.toFixed(2)}`)
}