// 2637. Promise Time Limit
/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 * 参考：<a href="https://leetcode.cn/problems/promise-time-limit/solutions/2238283/javascriptshi-xian-by-orange-2-1gxr/">
 */
var timeLimit = function (fn, t) {
    return async function (...args) {
        return Promise.race([
            fn(...args),
            new Promise((resolve, reject) => {
                setTimeout(() => {
                    reject('Time Limit Exceeded');
                }, t);
            })
        ]);
    }
};

timeLimit(async n => {
    await new Promise(res => setTimeout(res, 100));
    return n * n;
}, 50)(5);
timeLimit(async n => {
    await new Promise(res => setTimeout(res, 100));
    return n * n;
}, 150)(5);
timeLimit(async (a, b) => {
    await new Promise(res => setTimeout(res, 120));
    return a + b;
}, 150)(5, 10);
timeLimit(async () => {
    throw "Error";
}, 1000)();

