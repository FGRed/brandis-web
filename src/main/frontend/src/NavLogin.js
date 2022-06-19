import React from "react";
import LoginModal from "./LoginModal";
import RegisterModal from "./RegisterModal";
import "./NavLogin.css";
import Offcanvas from 'react-bootstrap/Offcanvas';
import {useState} from 'react';


export default function NavLogin(props){

    const redirectToLoginPage = function(){
        window.location.href = "/login"
    }

    const [showMenu, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const [logoutModalShow, setLogoutModalShow] = React.useState(false);

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
                    <button className="btn btn-primary btn-circle ms-2" onClick={handleShow} disabled={props.userLoggedIn === "false"}><i className="fas fa-u" ></i></button>
                    <Offcanvas placement="end" show={showMenu} onHide={handleClose}>
                                <Offcanvas.Header closeButton>
                                    <Offcanvas.Title >{document.querySelector("#username").value}<i className="fa fa-solid fa-bars ms-2"/></Offcanvas.Title>
                                </Offcanvas.Header>
                                <Offcanvas.Body>
                                    <h6 className="mb-2">Account</h6>
                                    <ul>
                                        <li>
                                            <a href="#">Account settings</a>
                                        </li>
                                        <li>
                                            <a href="#" onClick={()=>setLogoutModalShow(true)}>Logout</a>
                                        </li>
                                        <LoginModal
                                            show={logoutModalShow}
                                            onHide={()=> setLogoutModalShow(false)}
                                            userLoggedIn = {true}
                                        />
                                    </ul>
                                </Offcanvas.Body>
                                <div className="row w-100" >
                                    <div className="col justify-content-end">
                                        <small>Logged in user: {document.querySelector("#username").value}</small>
                                    </div>

                                </div>
                                <div className="row w-100">
                                    <div className="col justify-content-end">
                                        <small>Version: {document.querySelector("#version").value}</small>
                                    </div>
                                </div>
                            </Offcanvas>
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

