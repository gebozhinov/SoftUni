function loadingBar(number) {
    if (number === 100) {
        console.log("100% Complete!");
        console.log("[%%%%%%%%%%]");
    } else {
        let percentSign = number / 10;
        let dotSign = 10 - percentSign;
        console.log(`${number}% [${"%".repeat(percentSign)}${".".repeat(dotSign)}]`);
        console.log("Still loading...");
    }
}