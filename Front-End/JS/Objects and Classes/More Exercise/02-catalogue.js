function catalogue(input) {

    let products = [];

    for (let i = 0; i < input.length; i++) {
        let productName = input[i].split(" : ")[0];
        let productPrice = Number(input[i].split(" : ")[1]);

        let product = {
            productName,
            productPrice,
        }

        products.push(product);

    }

    products.sort((a, b) => a.productName.localeCompare(b.productName));
    let str = "";
    products.forEach(product => {
        
        if (str !== product.productName.charAt(0)) {
            str = product.productName.charAt(0);
            console.log(product.productName.charAt(0));
        }

        console.log(` ${product.productName}: ${product.productPrice}`);
    })

}