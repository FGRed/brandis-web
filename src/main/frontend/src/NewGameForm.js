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
                    id="form"
                >
                    <Form.Group className="mb-3" controlId="formBasicCompanyName">
                        <Form.Label>Company name</Form.Label>
                        <Form.Control name="companyName" type="text" placeholder="Enter company name" />
                        <Form.Label>Company slogan</Form.Label>
                        <Form.Control name="slogan" type="text" placeholder="Enter slogan" />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label className="mb-0">Difficulty</Form.Label>
                        <div className="mb-3">
                            <Form.Check name="difficulty" className="my-2" type="radio" label="Easy - start-up money 10k" id="easy" value="easy"/>
                            <Form.Check name="difficulty" className="my-2" type="radio" label="Normal - start-up money 5k" id="normal" value="normal"/>
                            <Form.Check name="difficulty" className="my-2" type="radio" label="Hard - start-up money 2.5k" id="hard" value="hard"/>
                            <Form.Check name="difficulty" className="my-2" type="radio" label="Chaos - start-up money 100" id="really-hard" value="very_hard"/>
                        </div>
                    </Form.Group>
                </Form>
                <Modal.Footer>
                    <Button variant="outline-primary" style={{float: "right"}} className="ms-2" onClick={props.onHide}>Cancel</Button>
                    <Button style={{float: "right"}} onClick={() => document.querySelector("#form").submit()} type="submit">Create game</Button>
                </Modal.Footer>
            </Modal.Body>
        </Modal>
    );
}
