// 2626. Array Reduce Transformation
/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function (nums, fn, init) {
    if (nums.length === 0) {
        return init;
    }
    nums.forEach((item, index, array) => {
        nums[index] = fn(init, nums[index]);
        init = nums[index];
    });
    return nums.pop();
};

console.log(reduce([1, 2, 3, 4], (accum, curr) => accum + curr, 0));
console.log(reduce([1, 2, 3, 4], (accum, curr) => accum + curr * curr, 100));
console.log(reduce([], (accum, curr) => 0, 25));