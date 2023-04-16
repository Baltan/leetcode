// 2632. Curry
/**
 * @param {Function} fn
 * @return {Function}
 * 参考：<a href="https://leetcode.com/problems/curry/solutions/3406845/simple-intuitive-javascript-solution-w-comments/">
 */
var curry = function (fn) {
    var args = [];

    return function curried(...newArgs) {
        args.push(...newArgs);
        return args.length === fn.length ? fn(...args) : curried;
    };
};

var curriedFn1 = curry((a, b, c) => a + b + c);
console.log(curriedFn1(1)(2)(3));

var curriedFn2 = curry((a, b, c) => a + b + c);
console.log(curriedFn2(1, 2)(3));

var curriedFn3 = curry((a, b, c) => a + b + c);
console.log(curriedFn3()()(1, 2, 3));

var curriedFn4 = curry(() => 42);
console.log(curriedFn4());
