import React from "react";
import LoginModal from "./LoginModal";


export default function NavLogin(props){

    const redirectToLoginPage = function(){
        window.location.href = "/login"
    }

    const [modalShow, setModalShow] = React.useState(false);

    let btnText = ''
    if(props.userLoggedIn === 'true'){
        btnText = 'Log Out'
    }else {
        btnText = 'Log In'
    }
    return (
        <div className="navbar-collapse">
            <div className="col col-auto mx-2">
                <button className="btn btn-primary" onClick={() => setModalShow(true)}>
                    {btnText}
                </button>
            </div>
            <div className="col col-auto">
                <button className="btn btn-outline-primary" onClick={redirectToLoginPage}>
                    Register
                </button>
            </div>
            <LoginModal
                show={modalShow}
                onHide={()=> setModalShow(false)}
            />
        </div>
    )
}

