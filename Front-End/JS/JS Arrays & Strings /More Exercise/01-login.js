function login(array) {
    let username = array[0];
    let passwords = array.slice(1);
    
    for (let i = 0; i < passwords.length; i++) {
        let currentPassword = passwords[i].split("").reverse().join("");
        if (currentPassword === username) {
            console.log(`User ${username} logged in.`)
            break;
        } else if (currentPassword !== username && i !== 3) {
            console.log("Incorrect password. Try again.");
        }

        if (i === 3) {
            console.log(`User ${username} blocked!`)
            break;
        }

    }

}

login(['sunny','rainy','cloudy','sunny','not sunny']);