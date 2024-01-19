import menus from '../data/menu-detail.json';

/* json 파일로부터 전체 메뉴 리스트 반환 */
export function getMenuList() {
    return menus;
}

/* MenuDetails에서 넘겨준 메뉴코드 값과 일치하는 메뉴 객체를 반환 */
export function getMenuDetail(menuCode) {
    console.log('detail 페이지에서 넘어온 메뉴 코드 값 : ', menuCode);
    console.log(typeof menuCode); // pathVariable에서 꺼내온 값은 문자열이다. 그래서 밑에서 사용할 때 파싱해줘야한다.

    return menus.filter((menu) => menu.menuCode === parseInt(menuCode))[0];
}

export function searchMenu(searchMenuName){
    return menus.filter((menu)=> menu.menuName.match(searchMenuName))

}