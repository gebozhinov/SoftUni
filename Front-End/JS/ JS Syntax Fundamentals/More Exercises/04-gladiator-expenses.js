function gladiatorExpenses(firstParam, secondParam, thirdParam, fourthParam, fifthParam) {

    let lostFights = parseInt(firstParam);
    let helmetPrice = parseFloat(secondParam);
    let swordPrice = parseFloat(thirdParam);
    let shieldPrice = parseFloat(fourthParam);
    let armorPrice = parseFloat(fifthParam);


    let shieldBrakedTimes = 0;
    let total = 0;

    for (let i = 1; i <= lostFights; i++) {
        if (i % 2 === 0) {
            total += helmetPrice;
        }

        if (i % 3 === 0) {
            total += swordPrice;
        }

        if (i % 2 === 0 && i % 3 === 0) {
            total += shieldPrice;
            shieldBrakedTimes += 1;
        }

        if (shieldBrakedTimes % 2 === 0 && shieldBrakedTimes > 0) {
            shieldBrakedTimes = 0;
            total += armorPrice;
        }
    }

    console.log(`Gladiator expenses: ${total.toFixed(2)} aureus`)
}