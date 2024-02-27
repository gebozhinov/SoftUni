function isMultiplicationResultIsPositiveOrNegative(numOne, numTwo, NumThree) {
    let numbers = [numOne, numTwo, NumThree];
    let getPositiveNumbers = numbers.filter(num => num > 0).length;
    console.log(getPositiveNumbers % 2 === 1 ? "Positive" : "Negative")
}

isMultiplicationResultIsPositiveOrNegative(5, 12, -15);
isMultiplicationResultIsPositiveOrNegative(-6, -12, 14);
isMultiplicationResultIsPositiveOrNegative(-1, -2, -3);
isMultiplicationResultIsPositiveOrNegative(-5, 1, 1)