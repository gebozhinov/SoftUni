function sameNumbers(number) {
    let num = number.toString();
    let isNumbersSame = true;
    let sum = parseInt(num[0]);
    for (let i = 1; i < num.length; i++) {
        let firstNum = num[0];
        let currentNum = num[i];
        sum += parseInt(currentNum);
        if (isNumbersSame == true && firstNum !== currentNum) {
            isNumbersSame = false;
        }
    }

    console.log(isNumbersSame);
    console.log(sum);
}