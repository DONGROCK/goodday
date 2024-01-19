import { Navigate } from 'react-router-dom'

function MyPage(){

/*
    컴포넌트 내에서 권한이나 다른 특정 상황에 의해 다른 페이지로 연동하고 싶을 때 Namvigate 컴포넌트를 사용할 수 있다.
    useNavigate랑 같은 거지만 함수식으로 작성할 것인지 컴포넌트 형태로 작성할 것인지에 따라서
    useNavigate와 Navigate 중에 선택을 하게 된다.
*/

const isLogin = false;
if(!isLogin){
    return <Navigate to='/login'/>
}

return(
    <div>
        <h1>마이 페이지</h1>
    </div>
)
}

export default MyPage