import React from "react"
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";
import FormRange from "react-bootstrap/FormRange";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import axios from "axios";
import {Form} from "react-bootstrap";

export default function TransferModal(props){

    const [transferSum, setTransferSum] = React.useState(0);

    const close = () => {
        setTransferSum(0);
        props.onHide();

    };
    const handleSubmit =()=>{
        const form = new FormData(document.querySelector("#transferForm"))

        axios.post("/transfer-funds/",
            form).then((response)=>{
                props.changeState();
                setTransferSum(0);
                props.onHide();

            });
    }
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
                    Transfer funds
                </Modal.Title>
            </Modal.Header>
            <Form id="transferForm">
            <Modal.Body>
                <Row>
                    <Col><h6>{props.from + ": " + (props.funds - transferSum) + ",-"}</h6></Col>
                    <input type="hidden" name="funder" value={props.funds - transferSum}/>
                    <Col className="col-5"><FormRange value={transferSum} max={props.funds} onChange={()=>setTransferSum(document.querySelector("#range").value)} id="range"></FormRange></Col>
                    <input type="hidden" name="receiver" value={props.companyFunds + + transferSum}/>
                    <Col><h6>{props.to + ": " + (props.companyFunds + + transferSum) + ",-"}</h6></Col>
                    <input type="hidden" name="method" value={props.method}/>
                </Row>
            </Modal.Body>
            <Modal.Footer>
                <Button onClick={()=>close()}>Cancel</Button>
                <Button variant="primary" onClick={handleSubmit}>
                    Confirm
                </Button>
            </Modal.Footer>
            </Form>
        </Modal>
    )
}