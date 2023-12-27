/*빌트인 전역 프로퍼티
    global property*/
    
    console.log(global.Infinity === Infinity); //true
    
    //양의 무한대
    console.log(10/0);

    //음의 무한대
    console.log(-10/0);
    console.log(typeof Infinity); // number


    //NaN: 숫자가 아님을 나타내는 숫자값
    console.log(global.NaN);//NaN
    console.log(Number('abc')); //NaN
    console.log(10*'abcd'); //NaN
    console.log(typeof NaN); //number

    // undifined : 원시타입 undefined
    console.log(global.undefined); // undefined
    let nothing;
    console.log(nothing); // undefined
    console.log(typeof undefined); // undefined

    
    
    
    
    
    
    

    
    
    
    
    