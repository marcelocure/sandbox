var Immutable = require('immutable');
var map1 = Immutable.Map({a:1, b:2, c:3});
var map2 = map1.set('b', 50);
console.log(map1.get('b'));
console.log(map2.get('b'));

var list1 = Immutable.List.of(1, 2);
console.log(list1);
list1.push(3, 4, 5);
console.log(list1);
var list2 = list1.push(3, 4, 5);
console.log(list2);

console.log('that is fuc*ing immutable');

var alpha = Immutable.Map({a:1, b:2, c:3, d:4});
console.log(alpha);
console.log(alpha.map((v, k) => k.toUpperCase()).join());

var map1 = Immutable.Map({a:1, b:2, c:3, d:4});
var map2 = Immutable.Map({c:10, a:20, t:30});
var obj = {d:100, o:200, g:300};
var map3 = map1.merge(map2, obj);
console.log(map3);

var myObject = {a:1,b:2,c:3};
var newObject = Immutable.Seq(myObject).map(x => x * x).toObject();
console.log(newObject);

var oddSquares = Immutable.Seq.of(1,2,3,4,5,6,7,8).filter(x => x % 2).map(x => x * x);
console.log(oddSquares);