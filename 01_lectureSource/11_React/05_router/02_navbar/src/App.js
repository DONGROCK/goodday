
import { BrowserRouter, Routes, Route} from 'react-router-dom'
import Main from './pages/Main';
import Layout from './Layouts/Layout';
import Mypage from './pages/Mypage';
import Login from './pages/Login';

function App() {
  return (
   <BrowserRouter>
   <Routes>
    <Route path='/' element={<Layout/>}>
      <Route index element={<Main/>}/>
      <Route path='main' element={<Main/>}/>
      <Route path='mypage' element={<Mypage/>}/>
      <Route path='login' element={<Login/>}/>
      </Route>
    </Routes>
   </BrowserRouter>
  );
}

export default App;
