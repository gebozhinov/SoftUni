function buyFruit(fruit, weightGrams, price) {
    let weightKg = weightGrams / 1000;
    let moneyNeeded = weightKg * price;
    console.log(`I need $${moneyNeeded.toFixed(2)} to buy ${weightKg.toFixed(2)} kilograms ${fruit}.`);
}