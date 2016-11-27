import test from 'ava'
import $http from 'http-as-promised'

test('compare strings', t => {
    console.log('strings')
    t.is('aa', 'aa');
});

test('compare bools', t => {
    console.log('bools')
    t.is(true, true);
});

test('promise', t => {
    console.log('promise1')
    return $http.get('https://reverb.com/api/articles')
    .then(res => {
        console.log('promise2')
        const response = JSON.parse(res[1])
        t.true(response.total>0)
    })
})

test('compare numbers in strings', t => {
    console.log('numbers in strings')
    t.is('12345', '12345');
});

test('compare names', t => {
    console.log('names')
    t.is('cure', 'cure');
});

test('test await', async t => {
    console.log('test await')
    const bar = Promise.resolve('bar');
    t.is(await bar, 'bar');
});