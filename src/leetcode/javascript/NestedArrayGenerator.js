// 2649. Nested Array Generator
/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function* (arr) {
    var nums = [];
    help(arr, nums);

    for (let num of nums) {
        yield num;
    }
};

function help(arr, nums) {
    for (var item of arr) {
        if (Array.isArray(item)) {
            help(item, nums);
        } else {
            nums.push(item);
        }
    }
}

var generator = inorderTraversal([[[6]], [1, 3], []]);
console.log(generator.next().value);
console.log(generator.next().value);
console.log(generator.next().value);
console.log(generator.next().done);

console.log("---------------------")

var generator = inorderTraversal([]);
console.log(generator.next().value);