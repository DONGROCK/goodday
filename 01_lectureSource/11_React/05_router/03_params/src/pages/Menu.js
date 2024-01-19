import { useEffect, useState } from 'react';
import { getMenuList } from '../api/MenuAPI';
import boxStyle from './Menu.module.css';
import MenuItem from '../components/MenuItem';
import { useNavigate } from 'react-router-dom';

function Menu(){

    const [menuList, setMenuList] = useState([])
    const [searchvalue, setSearchValue] = useState('')
    const navigate = useNavigate()
   
    useEffect(()=>{
        setMenuList(getMenuList())
    },[])

    const onClickHandler = () => {
        console.log('searchvalue^^^^^^',searchvalue);

        /*useNavigate 훅을 이용하여 링크를 이동시킬 수 있다.*/
        navigate(`/menu/search?menuName=${searchvalue}`)
        
    }


    return(
        <>
        <h1>판매메뉴 목록</h1>

    <div>
        <input 
        type="search" 
        name="menuName" 
        onChange={(e)=>{
            setSearchValue(e.target.value)
            }}
        />
        <button onClick={onClickHandler}>검색</button>
    </div>

    <div className={boxStyle.MenuBox}>
        {menuList.map((menu) =>(
            <MenuItem key={menu.menuCode} menu={menu}/>
            
        ))}
    </div>
        </>
    )
}
export default Menu