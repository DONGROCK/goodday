// 02 class expressions (클래스 표현식)

//1. 익명 클래스 표현식
let Tutor = class{
    teach(){
        console.log('이해하셨나요?');
        
    }
};

new Tutor().teach(); //클래스로 생성시 new를 붙여야 한다"는 말은
                    // 클래스를 통해 객체(인스턴스)를 생성하려면 new 키워드를 사용해야 한다
//이해하셧나요 출력



//2. 기명 클래스 표현식
let Tutee = class MyTutee{
    learn(){
        console.log('우와 이해했어요!');

        //[class MyTutee] 출력이돼
        console.log(MyTutee); // MyTutee 라는 이름은 오직 클래스 안에서만 사용할 수 있따.
        
    }
};

new Tutee().learn();


//MyTutee is not defined, MyTutte는 클래스 밖에서 사용할 수 없다.
// console.log(MyTutee);

//3. 클래스 동적 생성
function makeTutee(message){

    return class{
        feedback(){
            console.log(message);
            
        }
    };
}
let SecondTutee = makeTutee('message값을 넣는다');
new SecondTutee().feedback();




/*
==> 클래스 표현식 정의가 가능하다는 것의 의미는 함수처럼 클래스도
    일급 객체이며 다른 표현식 내부에서 정의, 전달, 반환, 할당이 가능하다는 것
*/
