/*boolean 타입으로 변환*/
console.log('=========논리 타입으로 변환=========');

//자바스크립트 엔진은 boolean타입이 아닌 Truthy 값(참으로 평가 되는 값)
//또는 Falsy값(거짓으로 평가되는 값)으로 구분한다.
//Truthy -> true, Falsy -> false로 암묵적 타입 변환된다.
if(true) console.log('if(true)');
if(false) console.log('if(false)');         //Falsy
if(undefined) console.log('if(undifined)'); //Falsy
if(null) console.log('if(null)');           //Falsy
if(0) console.log ('if(0)');                //Falsy
if(NaN) console.log ('if(NaN)');            //Falsy
if('') console.log("if('')");               //Falsy

if('Javascript')console.log("if('Javascript')");

//false, undifined, null, 0, NaN, ''(빈문자열) 은 Falsy값이며
//이외의 모든 값은 Truthy값이다.