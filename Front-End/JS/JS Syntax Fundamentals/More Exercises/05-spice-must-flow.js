function minedSpice(num) {
    let yield = parseInt(num);

    let extractedSpice = 0;
    let daysMined = 0;
    while (yield >= 100) {

        extractedSpice += yield;
        extractedSpice -= 26;
        yield -= 10;
        daysMined += 1;
    }

    extractedSpice -= 26;
    if (extractedSpice < 0) {
        extractedSpice = 0;
    }
    console.log(daysMined);
    console.log(extractedSpice);
}