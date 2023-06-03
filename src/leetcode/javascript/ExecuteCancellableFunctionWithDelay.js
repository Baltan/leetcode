// 2715. Execute Cancellable Function With Delay
/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function (fn, args, t) {
    var task = setTimeout(() => {
        return fn(...args);
    }, t);
    return () => {
        clearTimeout(task);
    };
};

setTimeout(() => cancellable(x => x * 5, [2], 20), 50);
setTimeout(() => cancellable(x => x ** 2, [2], 100), 50);
setTimeout(() => cancellable((x1, x2) => x1 * x2, [2, 4], 30), 100);