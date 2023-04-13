// 2618. Check if Object Instance of Class
/**
 * @param {Object} object
 * @param {Function} classFunction
 * @return {boolean}
 * 参考：<a href="https://leetcode.com/problems/check-if-object-instance-of-class/solutions/3406546/basic-javascript-solution-easy-to-understand-beginner-friendly/">
 */
var checkIfInstanceOf = function (obj, classFunction) {
    if (obj === undefined) {
        return false;
    }

    while (obj !== null) {
        if (obj.constructor === classFunction) {
            return true;
        }
        obj = Object.getPrototypeOf(obj);
    }
    return false;
};

console.log(checkIfInstanceOf(undefined, null));
console.log(checkIfInstanceOf(undefined, undefined));
console.log(checkIfInstanceOf(new Date(), Date));
console.log(checkIfInstanceOf(Date, Date));

class Animal {
};

class Dog extends Animal {
};
console.log(checkIfInstanceOf(new Dog(), Animal));