function numberModification(number) {
    while (true) {
        let sum = 0;
        let average = 0;
        let numberToStr = number.toString();
        for (let i = 0; i < numberToStr.length; i++) {
            sum += parseInt(numberToStr[i]);
        }

        average = sum / numberToStr.length;
        if (average > 5) {
            break;
        }

        number += "9";
    }

    console.log(number);

}