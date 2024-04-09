function addItem() {
    let inputElement = document.getElementById('newItemText').value;
   
    let list = document.getElementById('items');
    let element = document.createElement('li');
    element.textContent = inputElement;
    list.appendChild(element);

    let removeLink = document.createElement('a');
    removeLink.textContent = '[Delete]';
    removeLink.href = '#';
    element.appendChild(removeLink);
    document.getElementById('newItemText').value = '';

   removeLink.addEventListener('click', removeElement);

   function removeElement() {
    list.removeChild(element)
   }
   
}