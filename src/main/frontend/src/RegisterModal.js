import React from "react";
import Modal from "react-bootstrap/Modal";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";


class RegisterModal extends React.Component{

    constructor(props) {
        super(props);
    }

    render() {return(
        <Modal
            {...this.props}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Register
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form
                    method="post"
                    action="/register/"
                    id="registerForm"
                >
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Email address</Form.Label>
                        <Form.Control className="mb-2" name="new-username" type="email" placeholder="Enter email" />
                        <Form.Control className="mb-2" name="new-username2" type="email" placeholder="Confirm email" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Password</Form.Label>
                        <Form.Control className="mb-2" name="new-password" type="password" placeholder="Password" />
                        <Form.Control name="new-password2" type="password" placeholder="Confirm password" />
                    </Form.Group>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="outline-primary" onClick={this.props.onHide}>Close</Button>
                <Button variant="primary" type="submit"
                        onClick={()=>document.querySelector("#registerForm").submit()}>
                    Register
                </Button>
            </Modal.Footer>
        </Modal>
    )
    }
}

export default RegisterModal