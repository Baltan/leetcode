// 2619. Array Prototype Last
Array.prototype.last = function () {
    if (this.length === 0) {
        return -1;
    }
    return this.pop();
};

console.log([1, 2, 3].last());
console.log([].last());