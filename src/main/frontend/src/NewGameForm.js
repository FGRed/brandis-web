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
                    New Game
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form
                    method="post"
                    action="/create-new-game/"
                >
                    <Form.Group className="mb-3" controlId="formBasicCompanyName">
                        <Form.Label>Company name</Form.Label>
                        <Form.Control name="companyName" type="text" placeholder="Enter company name" />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label className="mb-2">Difficulty</Form.Label>
                        <div className="mb-3">
                            <Form.Check inline name="difficulty" className="my-3" type="radio" label="Easy" id="easy" value="easy"/>
                            <Form.Check inline name="difficulty" className="my-3" type="radio" label="Normal" id="normal" value="normal"/>
                            <Form.Check inline name="difficulty" className="my-3" type="radio" label="Hard" id="hard" value="hard"/>
                            <Form.Check inline name="difficulty" className="my-3" type="radio" label="Really hard" id="really-hard" value="very_hard"/>
                        </div>
                    </Form.Group>
                    <Button type="submit">Create game</Button>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button onClick={props.onHide}>Close</Button>
            </Modal.Footer>
        </Modal>
    );
}
