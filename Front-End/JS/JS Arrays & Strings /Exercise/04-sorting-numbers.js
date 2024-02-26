function sortArray(array) {
    array.sort((a, b) => a - b);
    
    let result = [];

    while(array.length != 0) {
        let firstNum = array.shift();
        let lastNum = array.pop();

        result.push(firstNum);
        result.push(lastNum);
    }

    return(result);

}
