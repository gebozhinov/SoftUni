function printAndSUm(num1, num2) {
    let result = "";
    let sum = 0
    for (let i = num1; i <= num2; i++) {
        result += i + " ";
        sum += i;
    }

    console.log(result);
    console.log(`Sum: ${sum}`);
}