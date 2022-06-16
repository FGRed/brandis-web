import React from "react";
import Offcanvas from 'react-bootstrap/Offcanvas';
import {useState} from 'react';
import "./Menu.css"

function Menu(props){

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
     return(
        <div>
        <button className="btn btn-outline-primary btn-lg" onClick={handleShow} disabled={props.userLoggedIn === "false"}>
            <i className="fa fa-solid fa-bars"/>
        </button>
        <Offcanvas show={show} onHide={handleClose}>
            <Offcanvas.Header closeButton>
                <Offcanvas.Title >Main Menu<i className="fa fa-solid fa-bars ms-2"/></Offcanvas.Title>
            </Offcanvas.Header>
            <Offcanvas.Body>
                <h6 className="mb-2">Company</h6>
                <ul className="list-group mb-3">
                    <li>
                        <a href="#" className="list-group-item">Monthly Investment Accumulation</a>
                    </li>
                    <li>
                        <a href="#" className="list-group-item">Annual Investment Accumulation</a>
                    </li>

                    <li>
                        <a href="#" className="list-group-item">Bank</a>
                    </li>
                    <li>
                        <a href="#" className="list-group-item">Charity</a>
                    </li>
                    <li>
                        <a href="#" className="list-group-item">Stats</a>
                    </li>
                </ul>
                <h6 className="mb-2">Game</h6>
                <ul className="list-group">
                    <li>
                        <a href="#" className="list-group-item">Load Game</a>
                    </li>
                    <li>
                        <a href="#" className="list-group-item">Save Game</a>
                    </li>
                    <li>
                        <a href="#" className="list-group-item">New Game</a>
                    </li>
                    <li>
                        <a href="#" className="list-group-item">Settings</a>
                    </li>
                </ul>
            </Offcanvas.Body>
        </Offcanvas>
        </div>
    );
}

export default Menu