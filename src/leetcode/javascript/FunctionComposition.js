// 2629. Function Composition
/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function (functions) {
    return x => {
        for (var i = functions.length - 1; i >= 0; i--) {
            x = functions[i](x);
        }
        return x;
    }
};

console.log(compose([x => x + 1, x => x * x, x => 2 * x])(4));
console.log(compose([x => 10 * x, x => 10 * x, x => 10 * x])(1));
console.log(compose([])(42));