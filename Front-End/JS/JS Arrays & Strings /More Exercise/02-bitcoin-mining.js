function mining(goldAmount) {

    let bitcoinPrice = 11949.16;
    let goldPricePerOneGram = 67.51;

    let money = 0;
    let totalBitcoinsBought = 0;
    let dayOfFirstBitcoinBought = 0;
    for (let i = 1; i <= goldAmount.length; i++) {
        let currentDayMinedGold = goldAmount[i - 1];
        if (i % 3 === 0) {
            currentDayMinedGold *= 0.7;
        }
        
        money += currentDayMinedGold * goldPricePerOneGram;
        while (money >= bitcoinPrice) {
            money -= bitcoinPrice;
            totalBitcoinsBought++;
            if (dayOfFirstBitcoinBought === 0) {
                dayOfFirstBitcoinBought = i;
            }
        }
    }
    console.log(`Bought bitcoins: ${totalBitcoinsBought}`)
    if (dayOfFirstBitcoinBought !== 0) {
        console.log(`Day of the first purchased bitcoin: ${dayOfFirstBitcoinBought}`)
    }
    console.log(`Left money: ${money.toFixed(2)} lv.`)
}