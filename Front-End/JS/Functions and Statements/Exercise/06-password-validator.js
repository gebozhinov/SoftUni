function passwordValidator(password) {
    let isPasswordValid = true;

    let sixToTenCharLength = /.{6,10}/gm;
    if (!sixToTenCharLength.test(password)) {
        console.log("Password must be between 6 and 10 characters");
        isPasswordValid = false;
    }

    let onlyLettersAndDigits = /^[a-zA-Z0-9]*$/gm;
    if (!onlyLettersAndDigits.test(password)) {
        console.log("Password must consist only of letters and digits");
        isPasswordValid = false;
    }

    let atLeastTwoDigits = /\d{2,}/gm;
    if (!atLeastTwoDigits.test(password)) {
        console.log("Password must have at least 2 digits");
        isPasswordValid = false;
    }

    if (isPasswordValid) {
        console.log("Password is valid");
    }
}