function validate() {
    let emailField = document.getElementById('email');
    emailField.addEventListener('change', validateEmail);

    function validateEmail() {
        const regex = /^[a-z]+@[a-z]+\.[a-z]+$/g;
        let email = emailField.value;
        if (regex.test(email)) {
            emailField.classList.remove('error')
        } else {
            emailField.classList.add('error'    )
        }
    }
}