function isDistanceValid(x1, y1, x2, y2) {
    let firstDisance = Math.sqrt(Math.pow((0 - x1), 2) + Math.pow((0 - y1), 2));
    if (firstDisance % 1 === 0) {
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`)
    } else {
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`)
    }

    let secondDisance = Math.sqrt(Math.pow((x2 - 0), 2) + Math.pow((y2 - 0), 2));
    if (secondDisance % 1 === 0) {
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`)
    } else {
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`)
    }

    let thirdDistance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    if (thirdDistance % 1 === 0) {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`)
    } else {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`)
    }
}   