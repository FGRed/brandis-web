import React from "react";
import Form from "react-bootstrap/Form"
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";

export default function NewGameForm(props){
    return (
        <Modal
            {...props}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered>
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Modal heading
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <h4>New Game</h4>
                <Form
                    method="post"
                    action="/create-new-game/"
                >
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Company name</Form.Label>
                        <Form.Control name="companyName" type="text" placeholder="Enter company name" />
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button onClick={props.onHide}>Close</Button>
            </Modal.Footer>
        </Modal>
    );
}
