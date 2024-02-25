function uppercase(str) {
    let array = str.toString().match(/\b\w+\b/g);
    let result = "";
    array.forEach(word => {
        result += word.toUpperCase() + ", ";
    });

    result = result.slice(0, -2);
    console.log(result);
}