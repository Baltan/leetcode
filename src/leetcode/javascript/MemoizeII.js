// 2630. Memoize II
/**
 * @param {Function} fn
 */
function memoize(fn) {
    var map = new Map();

    return (...args) => {
        var argCount = args.length;
        var caches = map.get(argCount);

        if (caches) {
            outer:
                for (var key of caches.keys()) {
                    for (var i = 0; i < argCount; i++) {
                        if ([...args][i] !== key[i]) {
                            continue outer;
                        }
                    }
                    return caches.get(key);
                }
            var value = fn(...args);
            caches.set([...args], value);
            count++;
            return value;
        } else {
            var value = fn(...args);
            caches = new Map();
            caches.set([...args], value);
            map.set(argCount, caches);
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
var o = {};
var memoize3 = memoize(fn);
console.log(memoize3(o, o));
console.log(count);
console.log(memoize3(o, o));
console.log(count);
console.log(memoize3(o, o));
console.log(count);