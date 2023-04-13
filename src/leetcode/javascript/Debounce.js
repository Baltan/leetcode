// 2627. Debounce
/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function (fn, t) {
    var time = 0;
    var func;

    return function (...args) {
        if (new Date().getTime() < time) {
            clearTimeout(func);
        }
        time = new Date().getTime() + t;
        func = setTimeout(fn.bind(this, ...args), t);
    }
};