import React from "react";
import Offcanvas from 'react-bootstrap/Offcanvas';
import {useState} from 'react';

function Menu(){

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
     return(

        <div>
        <button className="btn btn-outline-primary btn-lg my-2 mx-3" onClick={handleShow}>
            <i className="fa fa-solid fa-bars"/>
        </button>
        <Offcanvas show={show} onHide={handleClose}>
            <Offcanvas.Header closeButton>
                <Offcanvas.Title>Offcanvas</Offcanvas.Title>
            </Offcanvas.Header>
            <Offcanvas.Body>
                Some text as placeholder. In real life you can have the elements you
                have chosen. Like, text, images, lists, etc.
            </Offcanvas.Body>
        </Offcanvas>
        </div>
    );
}

export default Menu