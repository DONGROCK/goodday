/*boolean 타입으로 변환*/
console.log('====논리타입으로 변환=====');

//1. Boolean 생성자 함수를 new연산자 없이 호출하는 방법
// false, undefined, null, 0, NaN, ''(빈문자열) 은 Falsy값
console.log(Boolean('JavaScript'));
console.log(Boolean(''));
console.log(Boolean(1));
console.log(Boolean(0));
console.log(Boolean(NaN));
console.log(Boolean('NaN'));
console.log(Boolean(Infinity));
console.log(Boolean('Infinity'));
console.log(Boolean(null));
console.log(Boolean(undefined));
console.log(Boolean({}));
console.log(Boolean([]));

//2. !부정 논리 연산자를 두번 사용하는 방법
console.log(!!'JavaScript');
console.log(!!'');
console.log(!!1);
console.log(!!0);
console.log(!!NaN);
console.log(!!'NaN');
console.log(!!Infinity);
console.log(!!'Infinity');
console.log(!!null);
console.log(!!undefined);
console.log(!!{});
console.log(!![]);