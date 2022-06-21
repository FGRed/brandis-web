import './App.css';
import Navbar from "./Navbar";
import FinancesInfo from "./FinancesInfo";

function App() {

  let userLoggedIn = document.querySelector("#userLoggedIn").value;

  return (
      <>
        <Navbar userLoggedIn = {userLoggedIn}/>
        <div className="container">

            <FinancesInfo/>
        </div>
      </>
  );
}

export default App;
