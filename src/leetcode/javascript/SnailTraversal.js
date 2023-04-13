// 2624. Snail Traversal
/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function (rowsCount, colsCount) {
    if (this.length != rowsCount * colsCount) {
        return [];
    }
    var result = new Array(rowsCount);
    var row = 0;
    var col = 0;
    var down = true;

    for (var i = 0; i < rowsCount; i++) {
        result[i] = new Array(colsCount).fill(0);
    }

    this.forEach((item, index, array) => {
        result[row][col] = item;

        if (down) {
            row++;

            if (row === rowsCount) {
                row = rowsCount - 1;
                down = false;
                col++;
            }
        } else {
            row--;

            if (row < 0) {
                row = 0;
                down = true;
                col++;
            }
        }
    });
    return result;
}

console.log([19, 10, 3, 7, 9, 8, 5, 2, 1, 17, 16, 14, 12, 18, 6, 13, 11, 20, 4, 15].snail(5, 4));
console.log([1, 2, 3, 4].snail(1, 4));
console.log([1, 3].snail(2, 2));