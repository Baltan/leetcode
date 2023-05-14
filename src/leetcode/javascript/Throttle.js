// 2676. Throttle
/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 * 参考：<a href="https://leetcode.cn/problems/throttle/solutions/2268503/jia-suo-by-ran-1v-1h06/">
 */
var throttle = function (fn, t) {
    var callable = true;
    var arg;
    return function func(...args) {
        if (callable) {
            callable = false;
            fn(...args)
            setTimeout(() => {
                callable = true;

                if (arg) {
                    func(...arg);
                    arg = null;
                }
            }, t);
        } else {
            arg = args;
        }
    }
};