// 2665. Counter II
/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function (init) {
    var y = init;
    return {
        increment: () => ++y,
        decrement: () => --y,
        reset: () => {
            y = init;
            return y;
        }
    }
};

var counter = createCounter(5);
console.log(counter.increment());
console.log(counter.reset());
console.log(counter.decrement());

var counter = createCounter(0);
console.log(counter.increment());
console.log(counter.increment());
console.log(counter.decrement());
console.log(counter.reset());
console.log(counter.reset());