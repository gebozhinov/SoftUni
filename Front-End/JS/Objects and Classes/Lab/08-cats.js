function cats(arr) {

    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`)
        }
    }

    let cats = [];

    for (let i = 0; i < arr.length; i++) {
        let name = arr[i].split(" ")[0];
        let age = arr[i].split(" ")[1];

        cats.push(new Cat(name, age));
    }

    cats.forEach(cat => {
        cat.meow();
    });
}