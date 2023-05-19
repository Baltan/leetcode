// 2695. Array Wrapper
/**
 * @param {number[]} nums
 */
var ArrayWrapper = function (nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function () {
    return this.nums.reduce((x, y) => x + y, 0);
}

ArrayWrapper.prototype.toString = function () {
    return "[" + this.nums.join(",") + "]";
}

var obj1 = new ArrayWrapper([1, 2]);
var obj2 = new ArrayWrapper([3, 4]);
console.log(obj1 + obj2);

console.log("----------------------------------")

var obj3 = new ArrayWrapper([23, 98, 42, 70]);
console.log(String(obj3));

console.log("----------------------------------")

var obj4 = new ArrayWrapper([]);
var obj5 = new ArrayWrapper([]);
console.log(obj4 + obj5);