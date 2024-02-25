function sumDigits(number) {

    let num = number.toString();
    let sum = 0;
    for (let i = 0; i < num.length; i++) {
        sum +=  parseInt(num[i]);
    }

    console.log(sum)
}