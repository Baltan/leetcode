// 2726. Calculator with Method Chaining
class Calculator {
    /**
     * @param {number} value
     */
    constructor(value) {
        this.value = value;
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    add(value) {
        this.value += value;
        return this;
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    subtract(value) {
        this.value -= value;
        return this;
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    multiply(value) {
        this.value *= value;
        return this;
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    divide(value) {
        if (value === 0) {
            throw new Error("Division by zero is not allowed");
        }
        this.value /= value;
        return this;
    }

    /**
     * @param {number} value
     * @return {Calculator}
     */
    power(value) {
        this.value = Math.pow(this.value, value);
        return this;
    }

    /**
     * @return {number}
     */
    getResult() {
        return this.value;
    }
}

var calculator1 = new Calculator(10);
calculator1.add(5);
calculator1.subtract(7);
console.log(calculator1.getResult());

console.log("--------------------------------------")

var calculator2 = new Calculator(2);
calculator2.multiply(5);
calculator2.power(2);
console.log(calculator2.getResult());

console.log("--------------------------------------")

var calculator3 = new Calculator(20);
calculator3.divide(0);
console.log(calculator3.getResult());