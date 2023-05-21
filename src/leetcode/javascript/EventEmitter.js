// 2694. Event Emitter
class EventEmitter {
    constructor() {
        this.events = new Map();
    }

    subscribe(event, cb) {
        if (!this.events.has(event)) {
            this.events.set(event, new Set());
        }
        this.events.get(event).add(cb);
        return {
            unsubscribe: () => {
                this.events.get(event).delete(cb);
            }
        };
    }

    emit(event, args = []) {
        var results = [];

        if (this.events.has(event)) {
            this.events.get(event).forEach(cb => results.push(cb(...args)));
        }
        return results;
    }
}

var emitter = new EventEmitter();
console.log(emitter.emit("firstEvent"));
emitter.subscribe("firstEvent", function cb1() {
    return 5;
});
emitter.subscribe("firstEvent", function cb2() {
    return 6;
});
console.log(emitter.emit("firstEvent"));

console.log("---------------------------------------");

var emitter = new EventEmitter();
emitter.subscribe("firstEvent", function cb1(...args) {
    return args.join(',');
});
console.log(emitter.emit("firstEvent", [1, 2, 3]));
console.log(emitter.emit("firstEvent", [3, 4, 6]));

console.log("---------------------------------------");

var emitter = new EventEmitter();
var sub = emitter.subscribe("firstEvent", (...args) => args.join(','));
console.log(emitter.emit("firstEvent", [1, 2, 3]));
console.log(sub.unsubscribe());
console.log(emitter.emit("firstEvent", [4, 5, 6]));