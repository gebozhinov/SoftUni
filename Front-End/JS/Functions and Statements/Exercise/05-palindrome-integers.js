function checkPalindrome(arr) {

    for (let i = 0; i < arr.length; i++) {
        let currentNumToStr = arr[i].toString();
        let currentNumBackwards = currentNumToStr.split("").reverse().join("");

        if (currentNumToStr === currentNumBackwards) {
            console.log(true);
        } else {
            console.log(false);
        }
    }
}