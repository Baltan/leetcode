// 2623. Memoize
/**
 * @param {Function} fn
 */
function memoize(fn) {
    var map = new Map();

    return (...args) => {
        var key = args.join();

        if (map.has(key)) {
            return map.get(key);
        } else {
            var value = fn(...args);
            map.set(key, value);
            count++;
            return value;
        }
    }
}

var count = 0;
var sum = (a, b) => a + b;
var memoize1 = memoize(sum);
console.log(memoize1(...[2, 2]));
console.log(memoize1(...[2, 2]));
console.log(count);
console.log(memoize1(...[1, 2]));
console.log(count);

console.log("-----------------------------")

var count = 0;
var factorial = n => (n <= 1) ? 1 : (n * factorial(n - 1));
var memoize2 = memoize(factorial);
console.log(memoize2(2));
console.log(memoize2(3));
console.log(memoize2(2));
console.log(count);
console.log(memoize2(3));
console.log(count);

console.log("-----------------------------")

var count = 0;
var fib = n => n <= 1 ? 1 : fib(n - 1) + fib(n - 2);
var memoize3 = memoize(fib);
console.log(memoize3(5));
console.log(count);