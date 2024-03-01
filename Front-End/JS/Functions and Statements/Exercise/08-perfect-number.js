function findPerfectNumber(number) {

    let perfectNumber = 0;

    for (let i = 1; i < number; i++) {
        if (number % i === 0) {
            perfectNumber += i;
        }
    }

    if (number === perfectNumber) {
        console.log("We have a perfect number!");
    } else {
        console.log("It's not so perfect.");
    }
}