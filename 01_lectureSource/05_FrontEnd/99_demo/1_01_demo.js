

var grade = '운영자'; //'일반회원', '운영자'로 변경해서 테스트
var authority;
// 코드 작성


if(grade == '손님'){
    authority ='글읽기'
    
}else if(grade == '일반회원') {
    authority ='글읽기, 글쓰기'
} else{
    authority ="글 읽기, 글 쓰기, 글 삭제"
}

console.log(grade + "의 경우 " + authority + " 가 가능합니다.");