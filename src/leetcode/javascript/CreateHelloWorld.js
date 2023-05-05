// 2667. Create Hello World Function
/**
 * @return {Function}
 */
var createHelloWorld = function () {
    return function (...args) {
        return "Hello World";
    }
};

var f = createHelloWorld();
console.log(f());
console.log(f({}, null, 42));