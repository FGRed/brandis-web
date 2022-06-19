import React from "react";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form"

export default function LoginModal(props){
    return (
        <Modal
            onHide={props.onHide}
            show={props.show}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    {props.userLoggedIn ? "Logout" : "Login"}
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                {!props.userLoggedIn ?
                    <Form method="post" action="/module-login/" id="loginForm">
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control name="username" type="email" placeholder="Enter email" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control name="password" type="password" placeholder="Password" />
                        </Form.Group>

                    </Form> :
                    <h4>Sure you want to log out? Any unsaved progress will be lost!</h4>
                }
            </Modal.Body>
            <Modal.Footer>
                <Button onClick={props.onHide}>Cancel</Button>
                {!props.userLoggedIn ? <Button variant="primary" type="submit" onClick={() => document.querySelector("#loginForm").submit()}>
                    Login
                </Button> :
                <Button variant="primary"
                        type="submit" onClick={() =>
                    document.location.href = "/module-logout/"
                }>
                    Logout
                </Button>}
            </Modal.Footer>
        </Modal>
    );
}