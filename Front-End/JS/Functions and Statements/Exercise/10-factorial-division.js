function calculateFactorialAndPrintDivision(num1, num2) {
    let calculateFactorial = function(n) {
        if (n === 0 || n === 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    let fact1 = calculateFactorial(num1);
    let fact2 = calculateFactorial(num2)

    let result = fact1 / fact2;
    console.log(result.toFixed(2));
}

calculateFactorialAndPrintDivision(5,
    2)