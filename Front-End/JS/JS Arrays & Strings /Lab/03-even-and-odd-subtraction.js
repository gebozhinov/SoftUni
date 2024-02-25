function subtract(arr) {
    let even = 0;
    let odd = 0;
    for(let i = 0; i < arr.length; i++) {
        let currentNum = arr[i];
        if (currentNum % 2 === 0) {
            even += currentNum;
        } else {
            odd += currentNum;
        }
    }
    console.log(even - odd);
}