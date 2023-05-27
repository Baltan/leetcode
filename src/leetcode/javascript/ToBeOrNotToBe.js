// 2704. To Be Or Not To Be
/**
 * @param {string} val
 * @return {Object}
 */
var expect = function (val) {
    return {
        toBe(anotherVal) {
            if (val !== anotherVal) {
                throw new Error("Not Equal");
            }
            return true;
        },
        notToBe(anotherVal) {
            if (val === anotherVal) {
                throw new Error("Equal");
            }
            return true;
        }
    };
};

console.log(expect(5).toBe(5));
console.log(expect(5).toBe(null));
console.log(expect(5).notToBe(null));