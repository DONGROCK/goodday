var browser = 'chrome'; //'Chrome', 'Firefox' 등으로 변경해서 테스트

// if (browser == 'Edge') {
// console.log("Edge를 사용하고 계시네요!");
// } else if (browser == 'Chrome'
// || browser == 'Firefox'
// || browser == 'Safari'
// || browser == 'Opera') {
// console.log('저희 서비스가 지원하는 브라우저를 사용하고 계시네요.');
// } else {
// console.log('현재 페이지가 괜찮아 보이길 바랍니다!');
// }



switch(browser){
    case 'chrome' : console.log('크롬을 사용하시네요'); break;
    case 'Firefox' : console.log("파이어폭스을 사용하시네요"); break;
    case 'safari' : console.log("사파리를 사용하시네요"); break;
    case 'Opera' : console.log("오페라 사용하시네요"); break;

}