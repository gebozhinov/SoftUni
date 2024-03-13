class Laptop {
    info = {};
    isOn = false;
    quality = 0;
    constructor(info, quality) {
        this.info = {
            producer: info.producer,
            age: info.age,
            brand: info.brand,
        };
        this.quality = quality;
    }

    turnOn() {
        this.isOn = true;
        this.quality--;
        return this.isOn;
    }

    turnOff() {
        this.isOn = false;
        this.quality--;
        return this.isOn;
    }

    showInfo() {
        return JSON.stringify({
            producer: this.info.producer,
            age: this.info.age,
            brand: this.info.brand,
        })
    }

    get price() {
        return Number(800 - (this.info.age * 2) + (this.quality * 0.5))
    }
}