import React from "react"

export default function NavLogin(props){

    const redirectToLoginPage = function(){
        window.location.href = "/login"
    }

    let btnText = ''
    if(props.userLoggedIn === 'true'){
        btnText = 'Log out'
    }else {
        btnText = 'Log in'
    }
    return (
        <button className="btn btn-primary" onClick={redirectToLoginPage}>
            {btnText}
            <i className="fas fa-sign-in-alt ms-2"></i>
        </button>
    )
}

