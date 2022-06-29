import './App.css';
import Navbar from "./Navbar";
import FinancesInfo from "./FinancesInfo";
import Game from "./Game";

function App() {

  let userLoggedIn = document.querySelector("#userLoggedIn").value;

  return (
      <>
        <Navbar userLoggedIn = {userLoggedIn}/>
        <div className="container">
            <FinancesInfo/>
            <Game/>
        </div>
      </>
  );
}

export default App;
