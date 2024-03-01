function oddAndEvenSum(number) {
    let numberToStr = number.toString();

    let odd = 0;
    let even = 0;

    for (let i = 0; i < numberToStr.length; i++) {
        let currentNumber = parseInt(numberToStr[i]);
        if (currentNumber % 2 === 0) {
            even += currentNumber;
        } else {
            odd += currentNumber;
        }
    }

    console.log(`Odd sum = ${odd}, Even sum = ${even}`)
}