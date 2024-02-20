function operation(num1, num2, operator) {
    switch(operator) {
        case "+":
            console.log(num1 + num2);
            break;
        case "-":
            console.log(num1 - num2);
            break;
        case "*":
            console.log(num1 * num2);
            break;
        case "/":
            console.log(num1 / num2);
            break;
        case "%":
            console.log(num1 % num2);
            break;
        case "**":
            console.log(num1 + num2);
            break;
    }
}

operation(5, 6, '+')
operation(3, 5.5, '*')