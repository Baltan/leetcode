// 2620. Counter
/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function (n) {
    var num = n;

    return function () {
        return num++;
    };
};

var counter1 = createCounter(10);
console.log(counter1());
console.log(counter1());
console.log(counter1());

console.log("--------------------");

var counter2 = createCounter(-2);
console.log(counter2());
console.log(counter2());
console.log(counter2());
console.log(counter2());
console.log(counter2());