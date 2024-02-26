function rotation(arr, rotations) {

    for (let i = 0; i < rotations; i++) {
        let currentNum = arr.shift();
        arr.push(currentNum);
    }

    console.log(arr.join(" "));
}

rotation([51, 47, 32, 61, 21], 2)
rotation([32, 21, 61, 1], 4)