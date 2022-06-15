import React from "react"

export default function NavLogin(props){

    const redirectToLoginPage = function(){
        window.location.href = "/login"
    }

    let btnText = ''
    if(props.userLoggedIn === true){
        btnText = 'Log out'
    }else {
        btnText = 'Log in'
    }
    return (
            <input type="submit" className="btn btn-primary" value={btnText} onClick={redirectToLoginPage}/>
    )
}

