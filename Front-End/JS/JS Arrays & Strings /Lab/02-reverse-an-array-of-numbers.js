function reverse(n, arr) {
    let newArr = arr.slice(0, n)
    console.log(newArr.reverse());
}
reverse(3, [10, 20, 30, 40, 50])
reverse(4, [-1, 20, 99, 5])
reverse(2, [66, 43, 75, 89, 47])