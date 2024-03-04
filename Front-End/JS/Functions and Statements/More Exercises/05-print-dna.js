function printDNA(n) {
    let str = "ATCGTTAGGG";
    let count = 0;
    for (let i = 0; i < n; i++) {
        if (i % 4 === 0) {
            console.log(`**${str[count % 10]}${str[count % 10 + 1]}**`)
        } else if (i % 4 === 1) {
            console.log(`*${str[count % 10]}--${str[count % 10 + 1]}*`)
        } else if (i % 4 === 2) {
            console.log(`${str[count % 10]}----${str[count % 10 + 1]}`)
        } else if (i % 4 === 3) {
            console.log(`*${str[count % 10]}--${str[count % 10 + 1]}*`)
        }

        count += 2;
    }
}