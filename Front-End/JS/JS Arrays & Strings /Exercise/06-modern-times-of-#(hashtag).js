function hashtags(text) {
    let regex = /#[A-Za-x]+/gm;
    let result = text.match(regex);
   
    result.forEach(element => {
        console.log(element.substring(1));
    });
}