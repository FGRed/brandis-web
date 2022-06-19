import React from "react";
import LoginModal from "./LoginModal";
import RegisterModal from "./RegisterModal";
import "./NavLogin.css";



export default function NavLogin(props){

    const redirectToLoginPage = function(){
        window.location.href = "/login"
    }

    const [modalShow, setModalShow] = React.useState(false);
    const [registerModalShow, setRegisterModalShow] = React.useState(false);
    const userLoggedIn = props.userLoggedIn === "true"
    let btnText = ''
    if(userLoggedIn){
        btnText = 'Log Out'
    }else {
        btnText = 'Log In'
    }
    return (
        <div className="navbar-collapse">
            {!userLoggedIn && <div className="col col-auto">
                <button className="btn btn-primary" onClick={() => setModalShow(true)}>
                    {btnText}
                </button>
            </div>}
            {!userLoggedIn ?
                <div className="col col-auto ms-2">
                    <button className="btn btn-outline-primary" onClick={() => setRegisterModalShow(true)}>
                        Register
                    </button>
                </div> :
                <div className="col col-auto ms-2">
                    <button className="btn btn-primary btn-circle"><i className="fas fa-question"></i></button>
                    <button className="btn btn-primary btn-circle ms-2"><i className="fas fa-u"></i></button>
                </div>
            }
            <LoginModal
                show={modalShow}
                onHide={()=> setModalShow(false)}
                userLoggedIn = {userLoggedIn}
            />
            {!userLoggedIn && <RegisterModal
                show={registerModalShow}
                onHide={()=> setRegisterModalShow(false)}
            />}

        </div>
    )
}

