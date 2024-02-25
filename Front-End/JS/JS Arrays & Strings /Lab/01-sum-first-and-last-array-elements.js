function sum(arr) {
    let first = arr.shift();
    let last = arr.pop();
    console.log(first + last);
}

sum([20, 30, 40])
sum([10, 17, 22, 33])
sum([11, 58, 69])