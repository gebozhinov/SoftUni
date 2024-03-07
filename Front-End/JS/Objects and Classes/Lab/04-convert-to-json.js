function convertToJson(firstName, lastName, hairColor) {

    let obj = {
        name: firstName,
        lastName,
        hairColor,
    }

    console.log(JSON.stringify(obj))
}