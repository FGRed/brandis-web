import React from "react";
import Offcanvas from 'react-bootstrap/Offcanvas';
import {useState} from 'react';
import "./Menu.css"
import NewGameForm from "./NewGameForm"

function Menu(props){

    const [show, setShow] = useState(false);
    const [modalShow, setModalShow] = React.useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
     return(
        <div className="menu--container">
        <button className="btn btn-outline-primary btn-lg" onClick={handleShow} disabled={props.userLoggedIn === "false"}>
            <i className="fa fa-solid fa-bars"/>
        </button>
        <Offcanvas show={show} onHide={handleClose}>
            <Offcanvas.Header closeButton>
                <Offcanvas.Title >Main Menu<i className="fa fa-solid fa-bars ms-2"/></Offcanvas.Title>
            </Offcanvas.Header>
            <Offcanvas.Body>
                <h6 className="mb-2">Company</h6>
                <ul>
                    <li>
                        <a href="#">Monthly Investment Accumulation</a>
                    </li>
                    <li>
                        <a href="#">Annual Investment Accumulation</a>
                    </li>

                    <li>
                        <a href="#">Bank</a>
                    </li>
                    <li>
                        <a href="#">Charity</a>
                    </li>
                    <li>
                        <a href="#">Stats</a>
                    </li>
                </ul>
                <h6 className="mb-2">Game</h6>
                <ul>
                    <li>
                        <a href="#">Load Game</a>
                    </li>
                    <li>
                        <a href="#">Save Game</a>
                    </li>
                    <li>
                        <a href="#" onClick={() => setModalShow(true)}>New Game</a>
                    </li>
                    <li>
                        <a href="#">Settings</a>
                    </li>
                </ul>
            </Offcanvas.Body>
        </Offcanvas>
        <NewGameForm
            show={modalShow}
            onHide={()=> setModalShow(false)}
        />
        </div>
    );
}

export default Menu