// 2648. Generate Fibonacci Sequence
/**
 * @return {Generator<number>}
 */
var fibGenerator = function* () {
    var x = 0;
    var y = 1;

    for (var i = 0; ; i++) {
        if (i < 2) {
            yield i;
        } else {
            var num = x + y;
            var temp = num;
            x = y;
            y = temp;
            yield num;
        }
    }
};

var gen = fibGenerator(5);
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);