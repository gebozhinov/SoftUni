function orderPrice(product, amount) {
    const productsPrice = {
        coffee: 1.5,
        water: 1,
        coke: 1.4,
        snacks: 2,
    }

    const price = productsPrice[product];
    const totalPrice = price * amount;
    console.log(totalPrice.toFixed(2));
}