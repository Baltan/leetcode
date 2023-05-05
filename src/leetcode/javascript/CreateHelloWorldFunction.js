// 2667. Create Hello World Function
/**
 * @return {Function}
 */
var createHelloWorldFunction = function () {
    return function (...args) {
        return "Hello World";
    }
};

var f = createHelloWorldFunction();
console.log(f());
console.log(f({}, null, 42));