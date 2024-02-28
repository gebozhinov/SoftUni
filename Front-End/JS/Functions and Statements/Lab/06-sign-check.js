function isMultiplicationResultIsPositiveOrNegative(numOne, numTwo, NumThree) {
    let numbers = [numOne, numTwo, NumThree];
    let getPositiveNumbers = numbers.filter(num => num > 0).length;
    console.log(getPositiveNumbers % 2 === 1 ? "Positive" : "Negative")
}