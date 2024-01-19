import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Layout from './Layout/Layout';
import MyPage from './pages/MyPage';
import Login from './pages/Login';
import Main from './pages/Main';
import Error from './pages/Error';


function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Layout />} >
        <Route index element={<Main/>} />
        <Route path='main' element={<main />}/>
        <Route path='mypage' element={<MyPage />}/>
        <Route path='login' element={<Login />}/>
        </Route>
    <Route path='*' element={<Error />} />
    </Routes>
    </BrowserRouter>
  );
}

export default App;
