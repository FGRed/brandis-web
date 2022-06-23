import './App.css';
import Navbar from "./Navbar";
import FinancesInfo from "./FinancesInfo";
import Main from "./Main";

function App() {

  let userLoggedIn = document.querySelector("#userLoggedIn").value;

  return (
      <>
        <Navbar userLoggedIn = {userLoggedIn}/>
        <div className="container">
            <FinancesInfo/>
            <Main/>
        </div>
      </>
  );
}

export default App;
