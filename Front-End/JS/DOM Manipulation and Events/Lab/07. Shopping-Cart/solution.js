function solve() {
   const buttons = Array.from(document.getElementsByClassName('add-product'));

   buttons.forEach(button => button.addEventListener('click', addElement));
   let textArea = document.querySelector('textarea');
   let products = {}

   function addElement(e) {
     let product = e.currentTarget;
     let productName = product.parentElement.parentElement.getElementsByClassName('product-title')[0].textContent;
     let productPrice = Number(product.parentElement.parentElement.getElementsByClassName('product-line-price')[0].textContent);

     textArea.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`

     if (products.hasOwnProperty(productName)) {
            products[productName] += productPrice;
     } else {
      products[productName] = productPrice;
     }
   }

   const checkout = document.getElementsByClassName('checkout')[0];
   checkout.addEventListener('click', calcTotalPrice);
   function calcTotalPrice() {
      buttons.forEach(button => button.setAttribute('disabled', true));

      let totalPrice = Object.values(products).reduce((a, b) => a + b, 0).toFixed(2);

      textArea.value += `You bought ${Object.keys(products).join(", ")} for ${totalPrice}.\n`
      checkout.setAttribute('disabled', true);
   }
}