// 2666. Allow One Function Call
/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function (fn) {
    var count = 0;

    return function (...args) {
        return count++ ? undefined : fn(...args);
    }
};

var onceFn = once((a, b, c) => (a + b + c));
console.log(onceFn(1, 2, 3));
console.log(onceFn(2, 3, 6));

var onceFn = once((a, b, c) => (a * b * c));
console.log(onceFn(5, 7, 4));
console.log(onceFn(2, 3, 6));
console.log(onceFn(4, 6, 8));