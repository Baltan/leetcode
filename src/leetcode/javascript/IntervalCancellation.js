// 2725. Interval Cancellation
/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function (fn, args, t) {
    var foo = () => {
        fn(...args);
        return foo;
    };
    /**
     * setInterval(foo(), t)：0秒开始，每隔t毫秒执行一次
     * setInterval(foo, t)：t秒开始，每隔t毫秒执行一次
     */
    var task = setInterval(foo(), t);
    return () => clearInterval(task);
};

var cancel1 = cancellable(x => console.log(x * 2), [4], 2000);
setTimeout(cancel1, 11000);

var cancel2 = cancellable((x1, x2) => console.log(x1 * x2), [2, 5], 2500);
setTimeout(cancel2, 14000);

var cancel3 = cancellable((x1, x2, x3) => console.log(x1 + x2 + x3), [5, 1, 3], 5000);
setTimeout(cancel3, 18000);