function simpleCalculator(a, b, operator) {
    const calculator = {
        multiply: (a , b) => a * b,
        divide: (a, b) => a / b,
        add: (a, b) => a + b,
        subtract: (a, b) => a - b,
    }

    console.log(calculator[operator](a, b))
}