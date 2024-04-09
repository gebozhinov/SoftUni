function focused() {
   let fields = Array.from(document.getElementsByTagName('input'));

    for (const field of fields) {
        field.addEventListener('focus', onFocus);
        field.addEventListener('blur', onBlur);
    }

    function onFocus(e) {
        const parentElement = e.currentTarget.parentNode;
        parentElement.classList.add('focused');
    }

    function onBlur(e) {
        const parentElement = e.currentTarget.parentNode;
        parentElement.classList.remove('focused');
    }
}