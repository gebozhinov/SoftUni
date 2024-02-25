function cookingNumbers(str, op1, op2, op3, op4, op5) {
    let num = parseInt(str);
    let operations = [];
    operations.push(op1);
    operations.push(op2);
    operations.push(op3);
    operations.push(op4);
    operations.push(op5);

    operations.forEach(element => {
        switch (element) {
            case "chop":
                num /= 2;
                console.log(num) 
                break;
            case "dice":
                num = Math.sqrt(num);
                console.log(num) 
                break;
            case "spice":
                num += 1;
                console.log(num) 
                break;
            case "bake":
                num *= 3;
                console.log(num) 
                break;
            case "fillet":
                num *= 0.8;
                console.log(num) 
                break;
        }
    });
    
}