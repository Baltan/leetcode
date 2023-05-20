// 2693. Call Function with Custom Context
/**
 * @param {Object} context
 * @param {any[]} args
 * @return {any}
 */
Function.prototype.callPolyfill = function (context, ...args) {
    var foo = this.bind(context);
    return foo(...args);
}

var fn = function add(b) {
    return this.a + b;
}
console.log(fn.callPolyfill({"a": 5}, 7));

var fn = function tax(price, taxRate) {
    return `The cost of the ${this.item} is ${price * taxRate}`;
}
console.log(fn.callPolyfill({"item": "burger"}, 10, 1, 1));