function storeProvision(stock, products) {

    let currentStock = {};
    for (let i = 0; i < stock.length; i += 2) {
        let name = stock[i];
        let quantity = Number(stock[i + 1]);

        currentStock[name] = quantity;
    }

    for (let i = 0; i < products.length; i += 2) {
        let name = products[i];
        let quantity = Number(products[i + 1]);

        if (currentStock.hasOwnProperty(name)) {
            currentStock[name] += quantity;
        } else {
            currentStock[name] = quantity;
        }
    }

    for (const [key, value] of Object.entries(currentStock)) {
            console.log(`${key} -> ${value}`)
        
    }
}