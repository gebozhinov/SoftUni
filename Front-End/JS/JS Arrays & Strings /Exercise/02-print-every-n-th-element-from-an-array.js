function array(arr, step) {

    let result = [];

    for (let i = 0; i < arr.length; i += step) {
        let currentNum = arr[i];
        result.push(currentNum);
    }

    return(result);
}