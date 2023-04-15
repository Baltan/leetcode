// 2630. Memoize II
/**
 * @param {Function} fn
 */
function memoize(fn) {
    var index = 0;
    // 参数arg -> 参数arg对应的唯一索引
    var argIndexMap = new Map();
    var cache = new Map();

    return (...args) => {
        // 参数列表[...args]对应的索引数组，根据索引数组判断是否命中缓存
        var argIndexes = [];

        for (var arg of args) {
            if (!argIndexMap.has(arg)) {
                var argIndex = index++;
                argIndexMap.set(arg, argIndex);
                argIndexes.push(argIndex);
            } else {
                argIndexes.push(argIndexMap.get(arg));
            }
        }
        // 将索引数组转换成字符串
        var key = argIndexes.join("-");

        if (cache.has(key)) {
            return cache.get(key);
        } else {
            var value = fn(...args);
            cache.set(key, value);
            count++;
            return value;
        }
    }
}

var count = 0;
var fn = (a, b) => a + b;
var memoize1 = memoize(fn);
console.log(memoize1(2, 2));
console.log(count);
console.log(memoize1(2, 2));
console.log(count);
console.log(memoize1(1, 2));
console.log(count);

console.log("-----------------------------");

var count = 0;
var fn = (a, b) => ({...a, ...b});
var memoize2 = memoize(fn);
console.log(memoize2({}, {}));
console.log(count);
console.log(memoize2({}, {}));
console.log(count);
console.log(memoize2({}, {}));
console.log(count);

console.log("-----------------------------");

var count = 0;
var fn = (a, b) => ({...a, ...b});
var memoize3 = memoize(fn);
var o = {};
console.log(memoize3(o, o));
console.log(count);
console.log(memoize3(o, o));
console.log(count);
console.log(memoize3(o, o));
console.log(count);