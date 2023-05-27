// 2703. Return Length of Arguments Passed
/**
 * @return {number}
 */
var argumentsLength = function (...args) {
    return arguments.length;
};

console.log(argumentsLength(5));
console.log(argumentsLength({}, null, "3"));